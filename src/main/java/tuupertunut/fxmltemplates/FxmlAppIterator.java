/*
 * The MIT License
 *
 * Copyright 2017 Tuupertunut.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tuupertunut.fxmltemplates;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.netbeans.spi.project.ui.templates.support.Templates;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;

/**
 *
 * @author Tuupertunut
 */
public class FxmlAppIterator extends BaseJavaIterator {

    @Override
    public Set<FileObject> instantiate() throws IOException {
        FileObject targetFolder = Templates.getTargetFolder(wizard);
        FileObject mainTemplate = Templates.getTemplate(wizard);

        /* Retrieving the node templates relative to the main template. */
        FileObject rootNodeJavaTemplate = mainTemplate.getParent().getFileObject("FxmlNode.java");
        FileObject rootNodeFxmlTemplate = mainTemplate.getParent().getFileObject("FxmlNode.fxml");

        String mainClassName = Templates.getTargetName(wizard);
        String rootNodeClassName = mainClassName + "Pane";
        String rootNodeFxmlName = rootNodeClassName;

        DataFolder targetFolderData = DataFolder.findFolder(targetFolder);
        DataObject mainTemplateData = DataObject.find(mainTemplate);
        DataObject rootNodeJavaTemplateData = DataObject.find(rootNodeJavaTemplate);
        DataObject rootNodeFxmlTemplateData = DataObject.find(rootNodeFxmlTemplate);

        DataObject createdMainFileData = mainTemplateData.createFromTemplate(targetFolderData, mainClassName, Collections.singletonMap("rootNodeName", rootNodeClassName));
        DataObject createdRootNodeJavaFileData = rootNodeJavaTemplateData.createFromTemplate(targetFolderData, rootNodeClassName, Collections.singletonMap("fxmlName", rootNodeFxmlName));
        DataObject createdRootNodeFxmlFileData = rootNodeFxmlTemplateData.createFromTemplate(targetFolderData, rootNodeFxmlName);

        Set<FileObject> files = new HashSet<>();
        files.add(createdMainFileData.getPrimaryFile());
        files.add(createdRootNodeJavaFileData.getPrimaryFile());
        files.add(createdRootNodeFxmlFileData.getPrimaryFile());
        return files;
    }
}

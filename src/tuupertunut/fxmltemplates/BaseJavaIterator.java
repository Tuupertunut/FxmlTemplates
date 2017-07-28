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
import java.util.Set;
import javax.swing.event.ChangeListener;
import org.netbeans.spi.java.project.support.ui.templates.JavaTemplates;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;

/**
 *
 * @author Tuupertunut
 */
public class BaseJavaIterator implements WizardDescriptor.InstantiatingIterator<WizardDescriptor> {

    protected WizardDescriptor wizard;

    private WizardDescriptor.InstantiatingIterator<WizardDescriptor> delegate;

    public BaseJavaIterator() {
        delegate = JavaTemplates.createJavaTemplateIterator();
    }

    @Override
    public Set<FileObject> instantiate() throws IOException {
        return delegate.instantiate();
    }

    @Override
    public void initialize(WizardDescriptor wd) {
        wizard = wd;
        delegate.initialize(wd);
    }

    @Override
    public void uninitialize(WizardDescriptor wd) {
        wizard = null;
        delegate.uninitialize(wd);
    }

    @Override
    public WizardDescriptor.Panel<WizardDescriptor> current() {
        return delegate.current();
    }

    @Override
    public String name() {
        return delegate.name();
    }

    @Override
    public boolean hasNext() {
        return delegate.hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return delegate.hasPrevious();
    }

    @Override
    public void nextPanel() {
        delegate.nextPanel();
    }

    @Override
    public void previousPanel() {
        delegate.previousPanel();
    }

    @Override
    public void addChangeListener(ChangeListener cl) {
        delegate.addChangeListener(cl);
    }

    @Override
    public void removeChangeListener(ChangeListener cl) {
        delegate.removeChangeListener(cl);
    }
}

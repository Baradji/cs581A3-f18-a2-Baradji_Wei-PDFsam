/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 07/nov/2013
 * Copyright 2013 by Andrea Vacondio (andrea.vacondio@gmail.com).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.ui.workarea;

import static org.pdfsam.module.ModuleDescriptorBuilder.builder;

import java.io.IOException;
import java.util.function.Consumer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import org.pdfsam.module.ModuleCategory;
import org.pdfsam.module.ModuleDescriptor;
import org.pdfsam.module.PdfsamModule;
import org.pdfsam.ui.module.BaseTaskExecutionModule;
import org.sejda.model.parameter.base.TaskParameters;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Andrea Vacondio
 *
 */
@PdfsamModule
public class TestModule2 extends BaseTaskExecutionModule {

    private static final String SPLIT_MODULE_ID = "split";

    private ModuleDescriptor descriptor = builder().category(ModuleCategory.SPLIT).name("Split")
            .description("Split documents on a predefined set of pages").build();

    @Override
    public ModuleDescriptor descriptor() {
        return descriptor;
    }

    @Override
    protected TaskParameters buildParameters(Consumer<String> onError) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Pane getInnerPanel() {
        HBox pane = new HBox();
        pane.getChildren().add(new Label("Test label2"));
        return pane;
    }

    @Override
    public String id() {
        return SPLIT_MODULE_ID;
    }

    public Node graphic() {
        try {
            return (Group) FXMLLoader.load(new ClassPathResource("/fxml/TestModule2.fxml").getURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

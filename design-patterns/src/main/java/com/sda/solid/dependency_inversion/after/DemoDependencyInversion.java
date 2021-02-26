package com.sda.solid.dependency_inversion.after;

import com.sda.solid.dependency_inversion.after.higher.Document;
import com.sda.solid.dependency_inversion.after.higher.IContent;
import com.sda.solid.dependency_inversion.after.higher.IHeader;
import com.sda.solid.dependency_inversion.after.lower.Content;
import com.sda.solid.dependency_inversion.after.lower.JsonHeader;

public class DemoDependencyInversion {

    public static void main(String[] args) {
        IHeader header = new JsonHeader();
        IContent content = new Content();

        Document document = new Document(header, content);
        document.display();
    }
}

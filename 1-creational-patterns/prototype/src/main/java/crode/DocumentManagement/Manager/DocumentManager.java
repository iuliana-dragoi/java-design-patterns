package crode.DocumentManagement.Manager;

import crode.DocumentManagement.Template.DocumentTemplate;

import java.util.HashMap;
import java.util.Map;

public class DocumentManager {

    private Map<String, DocumentTemplate> templates = new HashMap<>();

    public void addTemplate(String key, DocumentTemplate template) {
        templates.put(key, template);
    }

    public DocumentTemplate getClonedTemplate(String key) {
        return templates.get(key).clone();
    }
}

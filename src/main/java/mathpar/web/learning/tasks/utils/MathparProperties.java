package mathpar.web.learning.tasks.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.client.RestTemplate;

@Getter
@NoArgsConstructor
public class MathparProperties {
    private String databaseUsername;
    private String databasePassword;
    private String databaseUrl;

    private String accountModulePrefix;


    public void loadPropertiesFromManager(String secretmanagerUrlPrefix) {
        RestTemplate restTemplate = new RestTemplate();
        var namespaceProperties = restTemplate.getForObject(secretmanagerUrlPrefix+"/getNamespaceProperties?namespace=tasks", TasksProperties.class);
        if(namespaceProperties==null) throw new RuntimeException("Can't load authentication properties");
        this.databasePassword = namespaceProperties.databasePassword;
        this.databaseUsername = namespaceProperties.databaseUsername;
        this.databaseUrl = namespaceProperties.databaseUrl;
        this.accountModulePrefix = namespaceProperties.accountUrl;
    }

    @Data
    public static class TasksProperties {
        @JsonProperty("DatabaseUrl")
        private String databaseUrl;
        @JsonProperty("DatabaseUsername")
        private String databaseUsername;
        @JsonProperty("DatabasePassword")
        private String databasePassword;
        @JsonProperty("AccountUrl")
        private String accountUrl;
    }
}

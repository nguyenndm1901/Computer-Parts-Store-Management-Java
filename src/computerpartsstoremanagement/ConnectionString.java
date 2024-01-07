package computerpartsstoremanagement;

public class ConnectionString {
    public static String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";

    public static String getUrl() {
        return url;
    }
}


// keytool -importcert -trustcacerts -alias TLS1 -file "J:\Microsoft RSA TLS CA 02.crt" -keystore "C:\Program Files\Amazon Corretto\jdk11.0.10_9\lib\security\cacerts"
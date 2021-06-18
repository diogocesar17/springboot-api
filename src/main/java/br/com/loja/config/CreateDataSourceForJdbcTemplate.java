package br.com.loja.config;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateDataSourceForJdbcTemplate {
    private static final String driverClassName = "org.mariadb.jdbc.Driver";
    private static final String url = "jdbc:mariadb://localhost:3306/LOJA";
    private static final String dbUsername = "root";
    private static final String dbPassword = "teste123";

    private static DataSource dataSource;

    public static void main(String[] args) throws Exception {

        dataSource = getDataSource();
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        System.out.println(dataSource.getClass());

    }

    public static DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setSchema("org.hibernate.dialect.MySQL5InnoDBDialect");
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }
}

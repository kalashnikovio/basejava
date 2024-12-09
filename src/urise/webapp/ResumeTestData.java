package urise.webapp;

import urise.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");

        resume.setContact(ContactType.PHONE, "+7 495 999 99 99");
        resume.setContact(ContactType.MOBILE, "+7 999 999 99 99");
        resume.setContact(ContactType.HOME_PHONE, "+7 800 999 99 99");
        resume.setContact(ContactType.SKYPE, "skype:grigory.kislin");
        resume.setContact(ContactType.MAIL, "gkislin@yandex.ru");
        resume.setContact(ContactType.LINKEDIN, "LinkedIn.com");
        resume.setContact(ContactType.GITHUB, "GITHUB.com");
        resume.setContact(ContactType.STATCKOVERFLOW, "STATCKOVERFLOW.com");
        resume.setContact(ContactType.HOME_PAGE, "HOME_PAGE.com");


        TextSection textSection = new TextSection("Ведущий стажировок и корпоративного обучения по" +
                " Java Web и Enterprise технологиям");
        resume.setSection(SectionType.OBJECTIVE, textSection);

        textSection = new TextSection("Аналитический склад ума, сильная логика, " +
                "креативность, инициативность. Пурист кода и архитектуры.");
        resume.setSection(SectionType.PERSONAL, textSection);

        List<String> items = new ArrayList<>();
        items.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения" +
                " автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на" +
                " Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для" +
                " комплексных DIY смет");
        items.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," +
                " \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP)." +
                " Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов." +
                " Более 3500 выпускников.");
        items.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk");
        items.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С," +
                " Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке:" +
                " Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, " +
                "интеграция CIFS/SMB java сервера.");
        items.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, " +
                "Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        items.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов " +
                "(SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о " +
                "состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и" +
                " мониторинга системы по JMX (Jython/ Django).");
        items.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, " +
                "Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        ListSection sectionList = new ListSection(items);
        resume.setSection(SectionType.ACHIEVEMENT, sectionList);

        items = new ArrayList<>();
        items.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        items.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        items.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, " +
                "MS SQL, HSQLDB");
        items.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        items.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        items.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC," +
                " Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), " +
                "Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        items.add("Python: Django.");
        items.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        items.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        items.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, " +
                "MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2," +
                " LDAP, OAuth1, OAuth2, JWT.");
        items.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        items.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, " +
                "iReport, OpenCmis, Bonita, pgBouncer");
        items.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектирования, архитектурных " +
                "шаблонов, UML, функционального программирования");
        items.add("Родной русский, английский \"upper intermediate\"");

        sectionList = new ListSection(items);
        resume.setSection(SectionType.QUALIFICATIONS, sectionList);

        List<Organization> listOrganizationSection = new ArrayList<>();
        LocalDate starDate = LocalDate.of(2013, 10, 1);
        LocalDate endDate = LocalDate.of(9999, 12, 31);
//        Organization organization = new Organization("Java Online Projects", "http://JavaOnlineProjects.com",
//                new Organization.Position(new Link("Java Online Projects",
//                        "http://JavaOnlineProjects.com"),
//                        "Автор проекта.", starDate,  endDate,
//                        "Создание, организация и проведение Java онлайн проектов и стажировок.") );
//        listOrganizationSection.add(organization);

//        starDate = LocalDate.of(2014, 10, 1);
//        endDate = LocalDate.of(2016, 01, 1);
//        organization = new Organization("Wrike", "http://Wrike.com",
//                starDate, endDate, "Старший разработчик (backend).", "Проектирование и разработка " +
//                "онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, " +
//                "PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
//        listOrganizationSection.add(organization);
//
//        starDate = LocalDate.of(2010, 12, 1);
//        endDate = LocalDate.of(2012, 04, 1);
//        organization = new Organization("RIT Center", "http://RITCenter.com",
//                starDate, endDate, "Java архитектор.", "Организация процесса разработки системы ERP " +
//                "для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы " +
//                "(кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и " +
//                "серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), " +
//                "сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online " +
//                "редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, " +
//                "Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell " +
//                "remote scripting via ssh tunnels, PL/Python");
//        listOrganizationSection.add(organization);

        OrganizationSection organizationSection = new OrganizationSection(listOrganizationSection);
        resume.setSection(SectionType.EXPERIENCE, organizationSection);


//        System.out.println(resume.getContact(ContactType.PHONE));

        for (ContactType type : ContactType.values()) {
//            System.out.print(type.getTitle() + ": " + resume.getContact(type) + "\n");
        }

        for (SectionType type : SectionType.values()) {
            if (type == SectionType.PERSONAL || type == SectionType.OBJECTIVE) {
                System.out.print(type.getTitle() + ": " + "\n" + resume.getSection(type));
            } else if (type == SectionType.ACHIEVEMENT || type == SectionType.QUALIFICATIONS) {
                System.out.println(type.getTitle() + ": ");
                sectionList = (ListSection) resume.getSection(type);
                items = sectionList.getItems();
                for (String item : items) {
                    System.out.println(item);
                }
            } else if (type == SectionType.EXPERIENCE) {
                System.out.println(type.getTitle() + ": ");
                organizationSection = (OrganizationSection) resume.getSection(type);
                listOrganizationSection = organizationSection.getOrganizations();
                for (Organization org : listOrganizationSection) {
                    System.out.println(org.toString());
                }
            }
            System.out.println();
        }
    }
}

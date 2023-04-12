package urise.webapp;

import urise.webapp.model.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("name1");

        resume.setContacts(ContactType.PHONE, "+7 495 999 99 99");
        resume.setContacts(ContactType.MOBILE, "+7 999 999 99 99");
        resume.setContacts(ContactType.HOME_PHONE, "+7 800 999 99 99");
        resume.setContacts(ContactType.SKYPE, "skype:grigory.kislin");
        resume.setContacts(ContactType.MAIL, "gkislin@yandex.ru");
        resume.setContacts(ContactType.LINKEDIN, "LinkedIn.com");
        resume.setContacts(ContactType.GITHUB, "GITHUB.com");
        resume.setContacts(ContactType.STATCKOVERFLOW, "STATCKOVERFLOW.com");
        resume.setContacts(ContactType.HOME_PAGE, "HOME_PAGE.com");


        TextSection section = (TextSection) new TextSection("Аналитический склад ума, сильная логика, " +
                "креативность, инициативность. Пурист кода и архитектуры.");
        resume.setSections(SectionType.PERSONAL, section);
        section = (TextSection) new TextSection("Организация команды и успешная реализация Java проектов для");
        resume.setSections(SectionType.OBJECTIVE, section);

    }
}

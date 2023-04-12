package urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final Period period;

//    private final LocalDate startDate;
//    private final LocalDate endDate;
    private final String title;
//    private final String description;

    public Organization(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(startDate, "startDate not null");
        Objects.requireNonNull(endDate, "endDate not null");
        Objects.requireNonNull(title, "title not null");
        this.homePage = new Link(name, url);
//        this.startDate = startDate;
//        this.endDate = endDate;
        this.title = title;
//        this.description = description;
        this.period = new Period(startDate, endDate, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        if (!period.equals(that.period)) return false;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + period.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", period=" + period +
                ", title='" + title + '\'' +
                '}';
    }
}

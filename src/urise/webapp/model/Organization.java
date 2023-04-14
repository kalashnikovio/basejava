package urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final String title;
    private  final List<Period> periods = new ArrayList<>();

    public Organization(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(startDate, "startDate not null");
        Objects.requireNonNull(endDate, "endDate not null");
        Objects.requireNonNull(title, "title not null");
        this.homePage = new Link(name, url);
        this.title = title;
        this.periods.add(new Period(startDate, endDate, description));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!Objects.equals(homePage, that.homePage)) return false;
        if (!title.equals(that.title)) return false;
        return periods.equals(that.periods);
    }

    @Override
    public int hashCode() {
        int result = homePage != null ? homePage.hashCode() : 0;
        result = 31 * result + title.hashCode();
        result = 31 * result + periods.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", title='" + title + '\'' +
                ", periods=" + periods +
                '}';
    }
}

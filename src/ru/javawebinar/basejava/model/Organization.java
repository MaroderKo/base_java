package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * gkislin
 * 19.07.2016
 */
public class Organization {
        List<Structure> info = new ArrayList<>();
    public Organization(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(title, "title must not be null");
        Structure structure = new Structure(new Link(name, url),startDate,endDate,title,description);
        info.add(structure);
    }
    public void addinfo(Organization org) {
        info.addAll(org.info);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        return info.equals(that.info);
    }

    @Override
    public int hashCode() {
        int result = info.get(0).homePage.hashCode();
        result = 31 * result + info.get(0).startDate.hashCode();
        result = 31 * result + info.get(0).endDate.hashCode();
        result = 31 * result + info.get(0).title.hashCode();
        result = 31 * result + (info.get(0).description != null ? info.get(0).description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder rez = new StringBuilder();
        rez.append("Organization{");
        for (Structure struct : info)
        {
            rez.append("homePage=" + struct.homePage +
                    ", startDate=" +  struct.startDate +
                    ", endDate=" +  struct.endDate +
                    ", title='" +  struct.title + '\'' +
                    ", description='" +  struct.description + '\'');
        }
        rez.append('}');
        return rez.toString();
    }

    class Structure
    {
        private Link homePage;
        private LocalDate startDate;
        private LocalDate endDate;
        private String title;
        private String description;
        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Structure(Link homePage, LocalDate startDate, LocalDate endDate, String title, String description) {
            this.homePage = homePage;
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
        }

        public Link getHomePage() {
            return homePage;
        }

        public void setHomePage(Link homePage) {
            this.homePage = homePage;
        }
    }
}


package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Generated;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String date;

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getname() {
        return this.name;
    }

    @Generated
    public String getDate() {
        return this.date;
    }
    

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setname(final String name) {
        this.name = name;
    }

    @Generated
    public void setDate(final String Date) {
        this.date = Date;
    }


    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Tarefa)) {
            return false;
        } else {
            Tarefa other = (Tarefa)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$name = this.getname();
                Object other$name = other.getname();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$Date = this.getDate();
                Object other$Date = other.getDate();
                if (this$Date == null) {
                    if (other$Date != null) {
                        return false;
                    }
                } else if (!this$Date.equals(other$Date)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Tarefa;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getname();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $Date = this.getDate();
        result = result * 59 + ($Date == null ? 43 : $Date.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "Tarefa(id=" + var10000 + ", name=" + this.getname() + ", Date=" + this.getDate() +  ")";
    }
}


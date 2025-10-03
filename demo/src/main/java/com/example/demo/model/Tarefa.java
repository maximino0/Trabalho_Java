
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Generated;
import org.springframework.data.domain.Example;

import java.util.List;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String date;
    private String status;
    private String tag;
    private boolean situacao;

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public boolean getSituacao() {
        return this.situacao;
    }

    @Generated
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    @Generated
    public String getTag() {
        return this.tag;
    }

    @Generated
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getDate() {
        return this.date;
    }

    @Generated
    public String getStatus() {
        return this.status;
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
    public void setStatus(final String Status) {
        this.status = Status;
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

                Object this$name = this.getName();
                Object other$name = other.getName();
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
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $Date = this.getDate();
        result = result * 59 + ($Date == null ? 43 : $Date.hashCode());
        Object $Status = this.getStatus();
        result = result * 59 + ($Status == null ? 43 : $Status.hashCode());
        return result;
    }



}


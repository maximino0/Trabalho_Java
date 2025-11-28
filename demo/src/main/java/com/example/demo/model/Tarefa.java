
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Tarefa {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    
    private Long id;
    
    private String name;
    
    private LocalDate date;
    
    private boolean status;
    
    private String tag;
    
    private boolean situacao;
    
    private String resume;
    
    private Integer difficult;

    private Long idUser;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean getStatus() {
        return status;
    }

    public String getTag() {
        return tag;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public String getResume() {
        return resume;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public Long getIdUser() {return idUser;}



    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public void setIdUser(User user) {
        this.idUser = user.getId();
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
    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", tag='" + tag + '\'' +
                ", situacao=" + situacao +
                ", resume='" + resume + '\'' +
                ", difficult=" + difficult +
                '}';
    }
}


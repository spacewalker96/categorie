package com.basma.categorie.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "payment-table")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long idPayment;
    @Column(name = "payment-date")
    private Date paidDate ;
    @Column(name = "payment-total")
    private Double total;
    @Column(name = "payment-details")
    private String details;
    @Column(name = "payment-methode")
    private String methode;

    public Payment() {

    }

    public Long getId() {
        return idPayment;
    }

    public void setId(Long id) {
        this.idPayment = id;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public Payment(Long idPayment, Date paidDate, Double total, String details, String methode) {
        this.idPayment = idPayment;
        this.paidDate = paidDate;
        this.total = total;
        this.details = details;
        this.methode = methode;
    }

    public Payment(Date paidDate, Double total, String details, String methode) {
        this.paidDate = paidDate;
        this.total = total;
        this.details = details;
        this.methode = methode;
    }
}

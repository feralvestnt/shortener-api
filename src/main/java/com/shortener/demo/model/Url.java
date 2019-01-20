package com.shortener.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="URL_ID_SEQ", sequenceName="URL_ID_SEQ", allocationSize = 1)
@Table(name = "URL")
public class Url {

    @Id
    @GeneratedValue(generator = "URL_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "SHORTED_ADDRESS")
    private String shortenedAddress;
}

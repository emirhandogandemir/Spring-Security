package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter 
@MappedSuperclass // Entity sınıflarında temel ortak tablo elemanlarını (id , soft-delete, updateDelete ,insertDate vs belirlemek için kullanılır
public abstract class BaseEntity implements Serializable {
	//Serialization işlemi, bir nesneyi, depolamak veya serileştirmek amacıyla istenen formata dönüştürme işlemidir.
	//Deserialization ise serileştirilmiş biçimdeki verilerin tekrar nesnelere dönüştürülmesi işlemidir.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

}
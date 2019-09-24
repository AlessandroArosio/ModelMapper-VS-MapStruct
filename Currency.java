package com.hpdlendscape.assetfinance.engine.infrastructure.database.meta;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

/**
 * com.hpdlendscape.assetfinance.engine.infrastructure.database.meta.Currency, created on 28/08/2019 15:18 <p>
 * @author AlessandroA
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "currency", schema = "meta", uniqueConstraints = {
    @UniqueConstraint(columnNames = "currency_code", name = "uniqueCurrencyName")})
public class Currency {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  // The unique constraint works only if JPA is creating the schema for us. Schemas are however created by liquibase
  @Size(min = 3, max = 3, message = "{currency.code.not.valid}")
  @Column(name = "currency_code", nullable = false, unique = true)
  private String currencyCode;

  @Column(name = "description", nullable = false)
  private String description;

  public Currency(String currencyCode, String description) {
    this.currencyCode = currencyCode;
    this.description = description;
  }
}

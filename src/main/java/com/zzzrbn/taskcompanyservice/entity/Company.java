package com.zzzrbn.taskcompanyservice.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.math.BigDecimal;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name="companies")
public class Company {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotBlank(message = "Company name is required")
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    @Min(value = 0, message = "Budget must be >= 0")
    @Column(name = "budget", nullable = false)
    private BigDecimal budget;
    
    @ElementCollection
    @CollectionTable(name = "company_users", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "userrecord_id")
    private List<Long> usersIds = new ArrayList<Long>();
    
    @Transient
    private List<Userrecord> userrecords;

	@Override
	public int hashCode() {
		return Objects.hash(budget, name, userrecords, usersIds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(budget, other.budget) && Objects.equals(name, other.name)
				&& Objects.equals(userrecords, other.userrecords) && Objects.equals(usersIds, other.usersIds);
	}    
}

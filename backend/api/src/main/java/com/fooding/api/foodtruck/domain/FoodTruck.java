package com.fooding.api.foodtruck.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fooding.api.foodtruck.domain.menu.Menu;
import com.fooding.api.owner.domain.Owner;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "foodtruck")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodTruck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "foodtruck_id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@Embedded
	@AttributeOverride(name = "licenseNumber", column = @Column(name = "license_number", nullable = false))
	@AttributeOverride(name = "name", column = @Column(name = "name", nullable = false))
	@AttributeOverride(name = "introduction", column = @Column(name = "introduction"))
	@AttributeOverride(name = "category", column = @Column(name = "category", nullable = false))
	@AttributeOverride(name = "phoneNumber", column = @Column(name = "phone_number", nullable = false))
	@AttributeOverride(name = "snsLink", column = @Column(name = "sns_link"))
	private FoodTruckInfo info;

	@Embedded
	@AttributeOverride(name = "bank", column = @Column(name = "bank", nullable = false))
	@AttributeOverride(name = "accountName", column = @Column(name = "account_name", nullable = false))
	@AttributeOverride(name = "accountNumber", column = @Column(name = "account_number", nullable = false))
	private BankInfo bankInfo;

	@OneToMany(mappedBy = "foodTruck")
	private List<Menu> menuList = new ArrayList<>();

	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Builder
	public FoodTruck(Owner owner, FoodTruckInfo info, BankInfo bankInfo) {
		this.owner = owner;
		this.info = info;
		this.bankInfo = bankInfo;
	}

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assetmanagement.entity;

import com.assetmanagement.util.RegexPattern;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "asset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asset.findAll", query = "SELECT a FROM Asset a")})
public class Asset implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assetId", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Supply> supplyList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)

    @Column(name = "id")
    private Integer id;

    @Column(name = "assetcode")
    private String assetcode;

    @Column(name = "serial_number")
    @Pattern(regexp = "^([A-Za-z0-9+-]?[\\W]?)*$", message = "Invalid Serial Number")
    private String serialNumber;

    @Column(name = "name")
    @Pattern(regexp = "^[\\$_a-zA-Z]+[\\$_\\w\\W]*$", message = "Invalid asset name")
    private String name;

    @Column(name = "purchase_price")
    @RegexPattern(regexp = "^([0-9]{0,6}[.][0-9]{2})$", message = "Invalid Purchase price")
    private BigDecimal purchasePrice;

    @Column(name = "procurementno")
    @Pattern(regexp = "^[\\d]{5}$", message = "Invalid procurement number")
    private Integer procurementno;

    @Column(name = "dointroduced")
    private LocalDate dointroduced;

    @Lob
    @Column(name = "description")
    @Pattern(regexp = "^.*$", message = "Invalid Description")
    private String description;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @JoinColumn(name = "assetstatus_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Assetstatus assetstatusId;

    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Branch branchId;

    @JoinColumn(name = "current_location", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Branch currentLocation;

    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Brand brandId;

    @JoinColumn(name = "emp_introduced", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employee empIntroduced;

    @JoinColumn(name = "holder_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employee holderId;

    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Subcategory subcategoryId;

    @JoinColumn(name = "model_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Model modelId;

    public Asset() {
    }

    public Asset(Integer id) {
        this.id = id;
    }

    public Asset(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getProcurementno() {
        return procurementno;
    }

    public void setProcurementno(Integer procurementno) {
        this.procurementno = procurementno;
    }

    public LocalDate getDointroduced() {
        return dointroduced;
    }

    public void setDointroduced(LocalDate dointroduced) {
        this.dointroduced = dointroduced;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Assetstatus getAssetstatusId() {
        return assetstatusId;
    }

    public void setAssetstatusId(Assetstatus assetstatusId) {
        this.assetstatusId = assetstatusId;
    }

    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
    }

    public Branch getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Branch currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public Employee getEmpIntroduced() {
        return empIntroduced;
    }

    public void setEmpIntroduced(Employee empIntroduced) {
        this.empIntroduced = empIntroduced;
    }

    public Employee getHolderId() {
        return holderId;
    }

    public void setHolderId(Employee holderId) {
        this.holderId = holderId;
    }

    public Subcategory getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Subcategory subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(String assetcode) {
        this.assetcode = assetcode;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Model getModelId() {
        return modelId;
    }

    public void setModelId(Model modelId) {
        this.modelId = modelId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asset)) {
            return false;
        }
        Asset other = (Asset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.assetmanagement.entity.Asset[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Supply> getSupplyList() {
        return supplyList;
    }

    public void setSupplyList(List<Supply> supplyList) {
        this.supplyList = supplyList;
    }
    
}

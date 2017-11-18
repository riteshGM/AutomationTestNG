package com.ibm.utils;

public class ZeusDataObject {
	
	private String CustSysID;
	
	private String ROLoginID;
	private String CAPurpose;
	private String SecurityValuationAmount;
	private String SecurityAssetType;
	private String SecurityTrustee;
	private String CASanctionDecision;
	private String PostSanctionApplicationOutcome;
	private String SecurityGoverningLaw;
	private String CASanctionerComments;
	private String SecurityAmount;
	private String FurtherPostSanctionComments;
	private String ExpectedSavedSecurity;
	private String ExpectedCAStatus;

	/*
	
	private String customerName;
	private String companyRegNo;
	private String customerStatus;
	private String customerClass;
	private String relationshipOwner;
	private String alwaysRefer;
	private String exposurePolicy;
	private String specAreaMarker;
	private String druFlag;
	private String custmClassification;
	private String marketCapital;
	private String high;
	private String dateApplied;
	private String low;
    private String customerSince;
	private String entity;
	private String businessEstalished;
	private String gcisId;
	private String registNumber;
	private String bicCode;
	
	//3rd part
	 private String add;
	 private String MonitorInformation;
	 private String AccountsMustInclude;
	 private String AccountType;
	 private String ConsolidationSpecific;
	 private String OutsideEntitiesApplicable;
	 private String ClickHeretoLinkFacil;
	 private String Frequency;
	 private String FirstPeriodend;
	 private String PeriodCovered;
	 private String NoofDaystoprovideby;
	 private String MonitorType;
	 private String CalculationType;
	 private String Formula;
	 private String NetRentalIncome ;
	 private String DebtService;
	 private String Notes;
	 private String TotalBorrowing;
	 private String NetTangibleAssets;
	 private String EBITDA;
	 private String TotalvalueofunencumUKbookdebtsinacco;
	 private String Borrowings;
	 private String NumberofDays;
	 private String CashFlow;
	 private String Exposure;
	 private String PropertyValue;
	 private String EBIT;
	 private String InterestPaid;
	 private String LoanValue;
	 private String NetTangibAssets;
	 private String NetTangibleAssetCurrentPeriod;
	 private String NetTangibleAssetsPriorPeriod;
	 private String TotalBorrowing1;
	 private String EBITDAoftheOperatingCompany;
	 private String DebtService1;
	 private String AdjustedEBITDA;
	 private String EBIToftheOperatingCompany1;
	 private String InterestPaid1;
	 private String LinkFacilities;
	 private String InternalBankInformationRequired; 
	 private String FormulaGroup;
	 private String FormulaName;
	 private String Comments;
	 private String FormulaNameOthersTextbox;
     private String CompareTo;
     private String Notes1;
     private String Frequency1;
     private String FirstPeriodEnd;
     private String FixedPeriodEndDate;
     private String FormulaDetailsFormula;
     private String FormulaDetailsNotes;
     private String FormulaDetailsLHSHeading;
     private String FormulaDetailsRHSHeading;
     private String Add;
     private String AddCheckbox ;
     private String CalculationBasis;
     private String PastMIPeriodRequired;
     private String SelfCertified;
     private String IsInterestRateRatchetApplicable;
     private String TargetCover;
     private String TypeofCover;
     private String ResultMustbe;
     private String TimesCover;
     private String SalesTeam;
     private String PrimaryRelationshipOwnerRO;
     private String SupportUser;
     private String CreditTeam;
     private String RCUTeam;
     private String RCUOwner;
     private String LA1Owner;
     private String LA2Owner;
     private String BBSResponsilbleforCase;
     private String BBSTeam;
     private String BBSCaseManager;
     private String BBSSupportUser;
     private String BBSResponsibleforMAndC;
     private String AlertType;
     private String LoginUsertype;
     private String CustomerType;
     private String IAID;
     private String IAName;
     private String IAReceived;
     private String  DateReceived;
     private String FromDate;
     private String ToDate;
     private String AttachDocuments;
     private String BatchAccountMustInclude;
     private String Calculations;
     private String BalanceSheet;
     private String ProfitAndLoss;
     private String CashFlow1;
     private String CalculationWaived;
     private String Currentpbt;
     private String Budgetpbt;
     private String PermissibleVaraince;
     private String PermissibleVarainceIndicator;
     private String CalculatedStatus;
     private String CurrentStatus;
     private String DeterioratingTrendDate;
     private String DuplicateInput;
     private String Copy;
     private String SaveORCalculate;
     private String Confirm;
     private String FacilityID;
     private String SortCode;
     private String AccNo;
     private String ProductCategory;
     private String Product; 
     private String Producttype;
     private String ExistingLimit;
     private String AnnualLendingFee;
     private String Margin;
     private String ReviewDate;
     private String MaturityORCancellationDate;
     private String Condition;
     private String Currency;
     private String IBAN;
     private String Country;
     private String RequestedLimit;
     private String RequestedLimitSLD;
     private String RequestedMOFLimit;
     private String IncreaseORDecrease;
     private String RequestedGrossLimit;
    // private String RequestedGrossLimit;
     private String RequestedNetLimit;
     private String NetIncreaseORDecrease;
     private String InterestMargin;
     private String RateBasis; 
     private String AmountFixed;
     private String FixedRatePeriodMont;
     private String Repricingrequired;
     private String RepricingDateORInterestMarginReviewDate;
     private String RePricePeriodYrs;
     private String FacilityUFN;
     private String MaturityDate;
     private String CancellationDate;
     private String ReviewDate1;
     private String InterestAppointment;
     private String InterestSettlementPeriod;
     private String WhichQuarters;
     private String InterestSettlementDay;
     private String OriginalTermMonths;
     private String LendingFee;
     private String ArrangementFee;
     //private String AnnualLendingFee1;
     private String IsThisaTradeFee;
     private String FeeFrequency;
     private String FeeChargeDate;
     private String FacilityPurpose;
     private String RepaymentSource;
     private String IsFacilitytobeonDemand;
     private String MinimumPrePaymentAmount;
     private String SFET;
     private String DealingMandateRequired; 
     private String Aggregatelimits;
     private String NonUtilisationFeeRequired;
     private String NonUtilisationFeePercentage;
     private String CommitmentFeeRequired;
     private String CommtmentFeePercantage;
     private String LoanFeetobeWaived;
     private String DebentureFormulae;
     private String ManagementAccountsRequired;
     private String FinancialCovenants;
     private String SpecialConditionsRequired;
     private String Specialonditions;
     private String RepaymentInstalmentAmount;
     private String IsitInnovationFinance;
     private String NameofArchitectOROperationalSurveyor;
     private String BuildingContract;
     private String TypeofBuildingContract;
     private String DateofBuildingContract;
     private String lanningConsentApplicable;
     private String ProviderofPlanningConsent;
     private String DateofPlanningConsent;
     private String DescriptionofDevelopment;
     private String NameofValuer;
     private String AmountofAcquisitionFacility;
     private String AmountofDevelopmenFacility;
     private String DevelopmentFacilityCannotExceed;
     private String NumberofPropertiestobeSoldforRepayment;
     private String PropertyType;
     private String CapitalRepaymentHolidayMonths;
     private String FirstPaymentDueDateorDays;
     private String FinalDrawdownDate;
     private String MultiCurrencypooling;
     private String LettersofCreditCharges;
     private String MMLCharges;
     private String ExcessInterestMargin;
     private String GroupArrangementLetterDate;
     private String FacilityLetterRequired;
     private String DaystoAcceptFacilityLetter;
     private String ExcessFee;
     private String ExcessPercentageRate;
     private String SettlementLimit;
     private String ApplicationNumber;
     private String BACSSunID;
     private String threeDayPayment;
     private String DaylightOverdraft;
     private String ClientAdviseletterRequired;
     private String ClientSpecificFacilityPurpose;
     private String ClientSpecificFacilityPurposDropDown;
     private String ClientSpecificFacilityPurposeComments;
     private String  InterestTurnRate;
     private String StagedDrawdownsRequired;
     private String NumberofDrawdowns;
     private String StagedDrawdowns;
     private String LateMIFeeApplicable;
     private String CurrenciesincludedinMOF;
     private String AvailableCurrencies;
     private String CAS2;
     private String CAS3;
     private String FacilityType;
     private String OilLC;
     private String Confirmation;
     private String DiscountORNegotiation;
     private String TrustFacility;
     private String ReleaseNoteFacility;
     private String Borrower;
     private String Otherfees; 
     private String otherfeestype;
     private String OtherLinkedFacilities;
     private String CABASIS;
  
     private String Daterequested;
     private String RoutingID;
     private String KYCcompleted;
     private String CurrentTab;
     private String CAID;
     private String Datecreated;
     private String CAStatus;
     private String FinancingGBP;
     private String CAOwner;
     private String ExpertLender;
     private String CAType;
     private String SecurityStatus;
     private String SecurityCharge;
     private String SecurityChargeId;
     private String SecurityCurrency;
     private String SecurityParty;
     private String SecurityPerfected;
     private String SecurityFeeWaived;
     private String SecurityAmount;
     private String SecurityAssetType;
     private String SecurityDetails;
     private String SecurityValuationAmount;
     private String SecurityaluationDate;
     private String SecurityFee;
     private String SecurityFeeIncludedinFORL;
     private String SecurityLinkedFacilities;
     private String EntityLevelSeverityModelValue;
     private String Istheseveritytobeappliedataconnectionorgrouplevel;
     private String Overriderequired;
     private String EntityLevelOverrideValue;
     private String SeverityOverrideAgreed;
     private String ConnectionLevelSeverity;
     private String OverrideReason;
     private String SeverityAgreesBy;
     private String SeverityDate;
     private String FinalSanctionedSeverityValue;
     private String SeverityModeltype;
     private String ArefacilitylevelSeverityvaluesrequired;
     private String FacilitySanctionedSeverityValue;
     private String SelectaFacility;
     private String FacilityLevelSeverityModelValue;
     private String FacilityLevelOverrideValue;
     private String Arefurtherfacilitylevelseverityvaluesrequired;
     private String SeverityCommentsRMorRDorMO;
     private String SeverityCommentsSanctioner;  */
     
     
 	public String getCustSysID() {
		return CustSysID;
	}
	public void setCustSysID(String customerSysId) {
		this.CustSysID = customerSysId;
	}
	
	public String getCAPurpose() {
		return CAPurpose;
	}
	public void setCAPurpose(String CAPurpose) {
		this.CAPurpose = CAPurpose;
	}
	
	
	public String getROLoginID() {
		return ROLoginID;
	}
	public void setROLoginID(String rOLoginID) {
		ROLoginID = rOLoginID;
	}
	public String getSecurityValuationAmount() {
		return SecurityValuationAmount;
	}
	public void setSecurityValuationAmount(String securityValuationAmount) {
		SecurityValuationAmount = securityValuationAmount;
	}
	public String getSecurityAssetType() {
		return SecurityAssetType;
	}
	public void setSecurityAssetType(String securityAssetType) {
		SecurityAssetType = securityAssetType;
	}
	public String getSecurityTrustee() {
		return SecurityTrustee;
	}
	public void setSecurityTrustee(String securityTrustee) {
		SecurityTrustee = securityTrustee;
	}
	public String getCASanctionDecision() {
		return CASanctionDecision;
	}
	public void setCASanctionDecision(String cASanctionDecision) {
		CASanctionDecision = cASanctionDecision;
	}
	public String getPostSanctionApplicationOutcome() {
		return PostSanctionApplicationOutcome;
	}
	public void setPostSanctionApplicationOutcome(
			String postSanctionApplicationOutcome) {
		PostSanctionApplicationOutcome = postSanctionApplicationOutcome;
	}
	public String getSecurityGoverningLaw() {
		return SecurityGoverningLaw;
	}
	public void setSecurityGoverningLaw(String securityGoverningLaw) {
		SecurityGoverningLaw = securityGoverningLaw;
	}
	public String getCASanctionerComments() {
		return CASanctionerComments;
	}
	public void setCASanctionerComments(String cASanctionerComments) {
		CASanctionerComments = cASanctionerComments;
	}
	public String getSecurityAmount() {
		return SecurityAmount;
	}
	public void setSecurityAmount(String securityAmount) {
		SecurityAmount = securityAmount;
	}
	public String getFurtherPostSanctionComments() {
		return FurtherPostSanctionComments;
	}
	public void setFurtherPostSanctionComments(
			String furtherPostSanctionComments) {
		FurtherPostSanctionComments = furtherPostSanctionComments;
	}
	public String getExpectedSavedSecurity() {
		return ExpectedSavedSecurity;
	}
	public void setExpectedSavedSecurity(String expectedSavedSecurity) {
		ExpectedSavedSecurity = expectedSavedSecurity;
	}
	public String getExpectedCAStatus() {
		return ExpectedCAStatus;
	}
	public void setExpectedCAStatus(String expectedCAStatus) {
		ExpectedCAStatus = expectedCAStatus;
	}
	
	
	

	
	
	/*
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCompanyRegNo() {
		return companyRegNo;
	}
	public void setCompanyRegNo(String companyRegNo) {
		this.companyRegNo = companyRegNo;
	}
	public String getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}
	public String getCustomerClass() {
		return customerClass;
	}
	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}
	public String getRelationshipOwner() {
		return relationshipOwner;
	}
	public void setRelationshipOwner(String relationshipOwner) {
		this.relationshipOwner = relationshipOwner;
	}
	public String getAlwaysRefer() {
		return alwaysRefer;
	}
	public void setAlwaysRefer(String alwaysRefer) {
		this.alwaysRefer = alwaysRefer;
	}
	public String getExposurePolicy() {
		return exposurePolicy;
	}
	public void setExposurePolicy(String exposurePolicy) {
		this.exposurePolicy = exposurePolicy;
	}
	public String getSpecAreaMarker() {
		return specAreaMarker;
	}
	public void setSpecAreaMarker(String specAreaMarker) {
		this.specAreaMarker = specAreaMarker;
	}
	public String getDruFlag() {
		return druFlag;
	}
	public void setDruFlag(String druFlag) {
		this.druFlag = druFlag;
	}
	public String getCustmClassification() {
		return custmClassification;
	}
	public void setCustmClassification(String custmClassification) {
		this.custmClassification = custmClassification;
	}
	public String getMarketCapital() {
		return marketCapital;
	}
	public void setMarketCapital(String marketCapital) {
		this.marketCapital = marketCapital;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getDateApplied() {
		return dateApplied;
	}
	public void setDateApplied(String dateApplied) {
		this.dateApplied = dateApplied;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getCustomerSince() {
		return customerSince;
	}
	public void setCustomerSince(String customerSince) {
		this.customerSince = customerSince;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getBusinessEstalished() {
		return businessEstalished;
	}
	public void setBusinessEstalished(String businessEstalished) {
		this.businessEstalished = businessEstalished;
	}
	public String getGcisId() {
		return gcisId;
	}
	public void setGcisId(String gcisId) {
		this.gcisId = gcisId;
	}
	public String getRegistNumber() {
		return registNumber;
	}
	public void setRegistNumber(String registNumber) {
		this.registNumber = registNumber;
	}
	public String getBicCode() {
		return bicCode;
	}
	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getNextRevDate() {
		return nextRevDate;
	}
	public void setNextRevDate(String nextRevDate) {
		this.nextRevDate = nextRevDate;
	}
	private String activity;
	//private String customerStatus;
	private String nextRevDate;  */

	
	
	

}

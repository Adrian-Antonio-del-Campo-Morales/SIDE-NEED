		
(deftemplate	ExecFunc)	
(deftemplate	ExecFunc_1)	
(deftemplate	ExecFunc_2)	
(deftemplate	ExecFunc_3)	
(deftemplate	ExecFunc_4)	
(deftemplate	ExecFunc_5)	
(deftemplate	ExecFunc_6)	
(deftemplate	ExecFunc_7)	
(deftemplate	ExecFunc_8)	
(deftemplate	ExecFunc_9)	
(deftemplate	AdapBeha)	
(deftemplate	AdapBeha_1)	
(deftemplate	AdapBeha_2)	
(deftemplate	AdapBeha_3)	
(deftemplate	AdapBeha_4)	
(deftemplate	AdapBeha_5)	
(deftemplate	AdapBeha_6)	
(deftemplate	AdapBeha_7)	
(deftemplate	AdapBeha_8)	
(deftemplate	AdapBeha_9)	
(deftemplate	AdapBeha_10)	
(deftemplate	AdapBeha_11)	
(deftemplate	AdapBeha_12)	
(deftemplate	AdapBeha_13)	
(deftemplate	AdapBeha_14)	
(deftemplate	AdapBeha_15)	
(deftemplate	AdapBeha_16)	
(deftemplate	SensPerc)	
(deftemplate	SensPerc_1)	
(deftemplate	SensPerc_2)	
(deftemplate	SensPerc_3)	
(deftemplate	SensPerc_4)	
(deftemplate	SensPerc_5)	
(deftemplate	SensPerc_6)	
(deftemplate	SensPerc_7)	
(deftemplate	SensPerc_8)	
(deftemplate	SensPerc_9)	
(deftemplate	SensPerc_10)	
(deftemplate	SocInter)	
(deftemplate	SocInter_1)	
(deftemplate	SocInter_2)	
(deftemplate	LogMat)	
(deftemplate	LogMat_1)	
(deftemplate	LingCommu)	
(deftemplate	LingCommu_1)	
(deftemplate	LingCommu_2)	
(deftemplate	LingCommu_3)	
(deftemplate	LingCommu_4)	
(deftemplate	LingCommu_5)	
(deftemplate	LingCommu_6)	
(deftemplate	LingCommu_7)	
(deftemplate	LingCommu_8)	
(deftemplate	LingCommu_9)	
(deftemplate	LingCommu_10)	
(deftemplate	LingCommu_11)	
(deftemplate	MotSkills)	
(deftemplate	MotSkills_1)	
(deftemplate	MotSkills_2)	
(deftemplate	MotSkills_3)	
(deftemplate diagnosis		
	(slot need)	
	(slot confidence)	
)		
		
(defglobal		
?*threshold_ADHDHP* = 0		
?*threshold_ADHDADP* = 0		
?*threshold_VD* = 0		
?*threshold_IDD* = 0		
		
?*possibleVariables_ASD* = 0		
?*possibleVariables_IDD* = 0		
?*possibleVariables_VD* = 0		
?*possibleVariables_HI* = 0		
?*possibleVariables_LD* = 0		
)		
		
		
(deffunction exists (?g)		
	   (if (any-factp ((?f ?g)) TRUE)	
	      then (return 1)	
	      else (return 0))	
)		
		


(defrule threshold_ADHDHP	
	(declare (salience 50)) 
=>	
	(bind ?*threshold_ADHDHP* (+ 
	(exists AdapBeha_1)
	(exists AdapBeha_2)
	(exists AdapBeha_3)
	(exists AdapBeha_4)
	(exists AdapBeha_7)
	(exists AdapBeha_16)
))	
	(assert (threshold_ADHDHP_checked))
)	
	
	
	
(defrule threshold_ADHDADP	
	(declare (salience 50)) 
=>	
	(bind ?*threshold_ADHDADP* (+ 
	(exists ExecFunc_1)
	(exists ExecFunc_2)
	(exists ExecFunc_3)
	(exists ExecFunc_4)
	(exists ExecFunc_5)
	(exists ExecFunc_9)
))	
	(assert (threshold_ADHDADP_checked))
)	
	
	
(defrule threshold_IDD	
	(declare (salience 50)) 
=>	
	(bind ?*threshold_IDD* (+ 
	(exists ExecFunc_2)
	(exists ExecFunc_3)
	(exists ExecFunc_4)
	(exists ExecFunc_5)
	(exists ExecFunc_9)
))	
	(assert (threshold_IDD_checked))
)	
	
	
	
(defrule threshold_VD	
	(declare (salience 50)) 
=>	
	(bind ?*threshold_VD* (+ 
	(exists SensPerc_2)
	(exists SensPerc_3)
	(exists SensPerc_4)
	(exists SensPerc_5)
	(exists SensPerc_6)
	(exists SensPerc_7)
	
))	
	(assert (threshold_VD_checked))
)	

	
(defrule assertion_ADHDHP	
	(declare (salience 20)) 
	
	(and
	(threshold_ADHDHP_checked)
	(test (> ?*threshold_ADHDHP* 3))
	)
=>	
	(assert (ADHDHP))
)	
	
	
(defrule assertion_ADHDADP	
	(declare (salience 20)) 
	
	(and
	(threshold_ADHDADP_checked)
	(test (> ?*threshold_ADHDADP* 3))
	)
=>	
	(assert (ADHDADP))
)	
	
(defrule assert_ADHDCOMBINED	
	(declare (salience 20)) 
	
	(and 
	(ADHDHP)
	(ADHDADP)
	)
=>	
	(assert (ADHDCOMBINED))
)	
	
	
(defrule assert_ASD	
	(declare (salience 20)) 
	
	(and
	(AdapBeha_5)
	(AdapBeha_10)
	(AdapBeha_11)
	(AdapBeha_13)
	(AdapBeha_14)
	(AdapBeha_15)
	(SensPerc_8)
	(SensPerc_9)
	(LingCommu_5)
	(not(ExecFunc_8))
	(not(LingCommu_6))
	)
=>	
	(assert (ASD))
)	
	
	
(defrule assert_IDD	
	(declare (salience 20)) 
	
	(and 
	(threshold_IDD_checked)
	(test (> ?*threshold_IDD* 1))
	(ExecFunc_6)
	(AdapBeha_9)
	(LogMat_1)
	(LingCommu_1)
	(LingCommu_2)
	(LingCommu_3)
	(LingCommu_7)
	(not(ExecFunc_7))
	(not(ExecFunc_8))
	(not(LingCommu_6))
	(not(MotSkills_2))
	)
	
=>	
	(assert (IDD))
)	
	
	
	
(defrule assert_SCD	
	(declare (salience 20)) 
	
	(and 
	(AdapBeha_8)
	(LingCommu_5)
	)
	
=>	
	(assert (SCD))
)	
	
	
	
	
(defrule assert_VD	
	(declare (salience 20)) 
	
	(and
	(threshold_VD_checked)
	(test (> ?*threshold_VD* 3))
	(SensPerc_1) 
	)
=>	
	(assert (VD))
)	
	
	
	
	
(defrule assert_HI	
	(declare (salience 20)) 
	
	(and 
	(SensPerc_10)
	(LingCommu_2)
	)
=>	
	(assert (HI))
)	
	
(defrule assert_CDD	
	(declare (salience 20)) 
	
	(and 
	(MotSkills_1)
	(MotSkills_3)
	)
=>	
	(assert (CDD))
)	
	
(defrule assert_SMD	
	(declare (salience 20)) 
	
	(and 
	(AdapBeha_14)
	)
=>	
	(assert (SMD))
)	
	
	
(defrule assert_LD	
	(declare (salience 19)) 
	
	(and 
	(LingCommu_1)
	(LingCommu_2)
	(LingCommu_3)
	(LingCommu_7)
	(not (HI))
	)
=>	
	(assert (LD))
)	
	
(defrule assert_LSD	
	(declare (salience 20)) 
	
	(and 
	(LogMat_1)
	(LingCommu_7)
	)
=>	
	(assert (LSD))
)	
	
(defrule assert_HC	
	(declare (salience 20)) 
	
	(and 
	(ExecFunc_7)
	(ExecFunc_8)
	(LingCommu_6)
	(not(ExecFunc_4))
	(not(ExecFunc_6))
	(not(ExecFunc_9))
	(not(AdapBeha_6))
	(not(AdapBeha_9))
	(not(AdapBeha_10))
	(not(AdapBeha_11))
	(not(AdapBeha_14))
	(not(LogMat_1))
	(not(LingCommu_1))
	(not(LingCommu_2))
	(not(LingCommu_3))
	(not(LingCommu_5))
	(not(LingCommu_7))
	(not(LingCommu_11))
	)
=>	
	(assert (HC))
)	


	
(defrule possibleVariables_ASD	
	(declare (salience 50)) 
=>	
	(bind ?*possibleVariables_ASD* (+ 
	(exists ExecFunc_2)
	(exists AdapBeha_7)
	(exists AdapBeha_12)
	(exists SensPerc_1)
	(exists SensPerc_2)
	(exists SensPerc_10)
	(exists SocInter_1)
	(exists SocInter_2)
	(exists LingCommu_2)
	(exists LingCommu_10)
	(exists LingCommu_11)
))	
	(assert (possibleVariables_ASD_checked))
)	
	
	
(defrule possibleVariables_IDD	
	(declare (salience 50)) 
=>	
	(bind ?*possibleVariables_IDD* (+ 
	(exists AdapBeha_6)
	(exists AdapBeha_7)
	(exists AdapBeha_12)
	(exists SensPerc_2)
	(exists LingCommu_5)
	(exists LingCommu_10)
	(exists LingCommu_11)
))	
	(assert (possibleVariables_IDD_checked))
)	
	
	
(defrule possibleVariables_VD	
	(declare (salience 50)) 
=>	
	(bind ?*possibleVariables_VD* (+ 
	(exists SocInter_1)
	(exists MotSkills_1)
))	
	(assert (possibleVariables_VD_checked))
)	
	
	
(defrule possibleVariables_HI	
	(declare (salience 50)) 
=>	
	(bind ?*possibleVariables_HI* (+ 
	(exists ExecFunc_2)
	(exists SensPerc_2)
	(exists SocInter_1)
	(exists SocInter_2)
	(exists LingCommu_1)
	(exists LingCommu_3)
	(exists LingCommu_4)
))	
	(assert (possibleVariables_HI_checked))
)	
	
	
(defrule possibleVariables_LD	
	(declare (salience 50)) 
=>	
	(bind ?*possibleVariables_LD* (+ 
	(exists LingCommu_4)
	(exists LingCommu_8)
	(exists LingCommu_9)
))	
	(assert (possibleVariables_LD_checked))
)	

(defrule diagnosis_ADHDHP	
	(declare (salience 10)) 
	(and 
	(ADHDHP)
	(not (ADHDCOMBINED))
	)
=>	
	(assert (diagnosis (need ADHD_HP)(confidence normal)))
)	
	
	
(defrule diagnosis_ADHDADP	
	(declare (salience 10)) 
	(and 
	(ADHDADP)
	(not (ADHDCOMBINED))
	)
=>	
	(assert (diagnosis (need ADHD_ADP)(confidence normal)))
)	
	
(defrule diagnosis_assert_ADHDCOMBINED	
	(declare (salience 10)) 
	(ADHDCOMBINED)
=>	
	(assert (diagnosis (need ADHD_COMBINED)(confidence normal)))
)	
	
(defrule diagnosis_ASD_High	
	(declare (salience 12)) 
	(and
	(ASD)
	(test (> ?*possibleVariables_ASD* 7))
	)
=>	
	(assert (ASD_done))
	(assert (diagnosis (need ASD)(confidence high)))
)	
	
(defrule diagnosis_ASD_Medium	
	(declare (salience 11)) 
	(and
	(not (ASD_done))
	(ASD)
	(test (> ?*possibleVariables_ASD* 4))
	)
=>	
	(assert (ASD_done))
	(assert (diagnosis (need ASD)(confidence medium)))
)	
	
(defrule diagnosis_ASD_Low	
	(declare (salience 10)) 
	(not (ASD_done))
	(ASD)
=>	
	(assert (diagnosis (need ASD)(confidence low)))
)	
	
(defrule diagnosis_IDD_High	
	(declare (salience 12)) 
	(and
	(IDD)
	(test (> ?*possibleVariables_IDD* 9))
	)
=>	
	(assert (IDD_done))
	(assert (diagnosis (need IDD)(confidence high)))
)	
	
(defrule diagnosis_IDD_Medium	
	(declare (salience 11)) 
	(and
	(not (IDD_done))
	(IDD)
	(test (> ?*possibleVariables_IDD* 5))
	)
=>	
	(assert (IDD_done))
	(assert (diagnosis (need IDD)(confidence medium)))
)	
	
(defrule diagnosis_IDD_Low	
	(declare (salience 10)) 
	(not (IDD_done))
	(IDD)
=>	
	(assert (diagnosis (need IDD)(confidence low)))
)	
	
	
(defrule diagnosis_SCD	
	(declare (salience 11)) 
	(and
	(SCD)
	)
=>	
	(assert (diagnosis (need SCD)(confidence normal)))
)	
	
	
	
(defrule diagnosis_VD_High	
	(declare (salience 12)) 
	(and
	(VD)
	(test (> ?*possibleVariables_VD* 7))
	)
=>	
	(assert (VD_done))
	(assert (diagnosis (need VD)(confidence high)))
)	


(defrule diagnosis_VD_Medium	
	(declare (salience 11)) 
	(and
	(VD)
	(test (> ?*possibleVariables_VD* 4))
	)
=>	
	(assert (VD_done))
	(assert (diagnosis (need VD)(confidence high)))
)
	
(defrule diagnosis_VD_Low	
	(declare (salience 10)) 
	(not (VD_done))
	(VD)
=>	
	(assert (diagnosis (need VD)(confidence low)))
)	
	
	
(defrule diagnosis_HI_High	
	(declare (salience 12)) 
	(and
	(HI)
	(test (> ?*possibleVariables_HI* 4))
	)
=>	
	(assert (HI_done))
	(assert (diagnosis (need HI)(confidence high)))
)	
	
(defrule diagnosis_HI_Medium	
	(declare (salience 11)) 
	(and
	(not (HI_done))
	(HI)
	(test (> ?*possibleVariables_HI* 2))
	)
=>	
	(assert (HI_done))
	(assert (diagnosis (need HI)(confidence medium)))
)	
	
(defrule diagnosis_HI_Low	
	(declare (salience 10)) 
	(not (HI_done))
	(HI)
=>	
	(assert (diagnosis (need HI)(confidence baja)))
)	
	
	
	
(defrule diagnosis_CDD	
	(declare (salience 10)) 
	(TDC)
=>	
	(assert (diagnosis (need CDD)(confidence normal)))
)	
	
	
(defrule diagnosis_SMD	
	(declare (salience 10)) 
	(TME)
=>	
	(assert (diagnosis (need SMD)(confidence normal)))
)	
	
	
(defrule diagnosis_LD_Low	
	(declare (salience 10)) 
	(LD)
=>	
	(assert (diagnosis (need LD)(confidence normal)))
)	
	
	
(defrule diagnosis_LSD	
	(declare (salience 10)) 
	(LSD)
=>	
	(assert (diagnosis (need LSD)(confidence normal)))
)	
	
	
(defrule diagnosis_HC	
	(declare (salience 10)) 
	(HC)
=>	
	(assert (diagnosis (need HC)(confidence normal)))
)	







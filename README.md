
[This repository is a part of the “Final Undergraduate Dissertation”:](https://github.com/Adrian-Antonio-del-Campo-Morales/SIDE-NEED)


# SIDE NEED

## Intelligent Decision Support System for Development Specific	Educational Needs.



Author: Adrian Antonio del Campo.

University: UCLM, ESCUELA SUPERIOR DE INFORMÁTICA, Ciudad Real.



[![N|ESI](http://webpub.esi.uclm.es/img/logo.png)](http://webpub.esi.uclm.es/pages/home)



[![N|UCLM](https://www.uclm.es/images/logos/Logo_uclm.png)](http://webpub.esi.uclm.es/pages/home)







# Contents
SIDE-NEED-Miner:

-	Used during the “DataMining” and “Knowledge Moulding” phases of the project.

SIDE-NEED-Questionnaire:
-	The final interface prototype developed for the project.








# SIDE-NEED-Miner User Guide
The correct use of the SIDE-NEED-Miner requires a thorogh understanding of the theoretical principles and specific characteristics of the project (explained in the project documentation).

The default path of the XLSX data files used in the application is:
```sh
C:/temp/
```
If other path is used, consider changing the following attributes of the classes:
```sh
	private static String inputFileName = "C:/temp/*****.xlsx";
	private static String outputFileName = "C:/temp/*****.xlsx";
```

#### Knowledge Moulding
For the correct execution of the “Knowledge Moulding” phase, the different applications must be executed in a particular order, and some intermediate operations should be performed.


##### ( 1 )
AttributeTransformator
 

```sh
	inputFileName = "C:/temp/OriginalSelectedFields.xlsx";
	outputFileName = "C:/temp/TransformedValues - Pre-NameChanges.xlsx";
```


##### ( 2 )
The names of the fields in the output file must be changed to the ones used in the project to identify the children characteristics (example:
 ExecFun_1) , and rearranged alphabetically.


##### ( 3 )
QuestionnaireAnswerer
```sh
	inputFileName = "C:/temp/TransformedValues - Names Changed.xlsx";
	outputFileName = "C:/temp/QuestionnaireAnswers  - Pre-Cleaning.xlsx";

```

##### ( 4 )
The output file will contain empty fields that must be eliminated.

##### ( 5 )
CLIPSDiagnosticSuggestor
```sh
	inputFileName = "C:/temp/QuestionnaireAnswers - Cleaned.xlsx";
	outputFileName = "C:/temp/DiagnosisSuggestions.xlsx";
```


#### Data Mining
```sh
	inputFileName = "C:/temp/PreprocesedDataset.xlsx";
	outputFileName = "C:/temp/TransformedDataset.xlsx";
```



#### Data resources

All the used datasets can be found at:


[GoogleDrive.](https://drive.google.com/open?id=1byBb0f88Tb7pdyckj-gwyOmJkUO7RYEk)




[![N|DRIVE](http://info.trello.com/hs-fs/hubfs/Power-Ups/Google%20Drive/google-drive-logo.png?t=1516830397712&width=600&name=google-drive-logo.png)](https://drive.google.com/open?id=1byBb0f88Tb7pdyckj-gwyOmJkUO7RYEk)


The original study can be found at:


[ECLS-K:2011.](https://nces.ed.gov/ecls/dataproducts.asp)


[![N|ECLS](https://nces.ed.gov/surveys/dbimages/ecls.gif)](https://nces.ed.gov/ecls/dataproducts.asp)


## External Resources and Installation:

### Apache POI 

[![N|POI](https://poi.apache.org/resources/images/asf_logo.png)](https://poi.apache.org/index.html)


For data access and processing, this project uses [Apache POI - the Java API for Microsoft Documents.](https://poi.apache.org/index.html).








#### Hardware Considerations:

The file processing can consume large amounts of RAM.

If the following error occurs, consider increasing the amount of memory allowed for the java applications.
```sh
$Java.lang.OutOfMemoryError: Java heap space
```


Eclipse Memory Configuration Example:
* In the “Run” menu, go to: Run Configurations.
* In the “Arguments” tab, include the following options:
-Xms512M -Xmx25000M


### CLIPS 

[![N|CLIPS](http://clipsrules.sourceforge.net/clips.gif)](http://clipsrules.sourceforge.net/)

For the diagnosis suggestion process, this projects uses  [CLIPS.](http://clipsrules.sourceforge.net/)

On Windows, it is necessary to verify that the correct DLL is installed.

If you have never used CLIPSJNI before then you should copy the CLIPSJNI.dll file
on one of the following paths: “C:\Windows” or “C:\Windows\System32”.

By default, the DLL for 64-bit Windows is used as the CLIPSJNI.dll file in the top
level of the CLIPSJNI directory. If running CLIPSJNI with 32-bit Windows, delete the
existing CLIPSJNI.dll file, then make a copy of the CLIPSJNI32.dll file and rename 
it to CLIPSJNI.dll.




If you are using the CLIPSJNI on Mac OS X, then the native CLIPS library is already
contained in the top level CLIPSJNI directory.



On other systems, you must created a native library using the source files contained 
in the library-src directory before you can utilize the CLIPSJNI.





WARNING: Some antivirus may run a quick analysis ore even block the execution.
Consider disabling them if this happens.

The CLIPSJNI jar file is also contained in the top level CLIPSJNI directory. The source files
used to create the jar file are contained in the java-src directory.



package com.example.com_pc.depression.NaiveBayes.DataObject;

import java.util.HashMap;
import java.util.Map;

public class DepressionData {

        // Age
        private int notDepFourteen=56;
        private int notDepFifteen=189;
        private int notDepSixteen=205;
        private int notDepSeventeen=144;
        private int depFourteen=5;
        private int depFifteen=37;
        private int depSixteen=44;
        private int depSeventeen=33;
        private int ageTotal=713;
        // Gender
        private int notDepMale=212;
        private int notDepFemale=382;
        private int depMale=11;
        private int depFemale=105;
        private int genderTotal=713;
        // Parents' marital status
        private int notDepMarried=528;
        private int notDepDivorced=38;
        private int notDepWidowed=23;
        private int depMarried=91;
        private int depDivorced=16;
        private int depWidowed=11;
        private int maritalStatusTotal=707;
        // Smoking
        private int notDepSmoking=459;
        private int notDepNotSmoking=126;
        private int depSmoking=84;
        private int depNotSmoking=33;
        private int smokingTotal=702;
        // Alcohol
        private int notDepAlcohol=544;
        private int notDepNotAlcohol=25;
        private int depAlcohol=105;
        private int depNotAlcohol=8;
        private int alcoholTotal=682;
        // Trouble with classmates
        private int notDepTroubleClassmates=310;
        private int notDepNotTroubleClassmates=266;
        private int depTroubleClassmates=32;
        private int depNotTroubleClassmates=86;
        private int troubleClassmatesTotal=694;
        // Family member seriously ill
        private int notDepFamilyIll=434;
        private int notDepNotFamilyIll=140;
        private int depFamilyIll=76;
        private int depNotFamilyIll=41;
        private int familyIllTotal=691;
        // Parents arguing with each other
        private int notDepParentsArguing=491;
        private int notDepNotParentsArguing=81;
        private int depParentsArguing=72;
        private int depNotParentsArguing=45;
        private int parentsArguingTotal=689;
        // Being seriously ill or injured
        private int notDepSeriouslyIll=489;
        private int notDepNotSeriouslyIll=84;
        private int depSeriouslyIll=92;
        private int depNotSeriouslyIll=25;
        private int seriouslyIllTotal=690;
        // Break up with lover
        private int notDepBreakup=408;
        private int notDepNotBreakup=164;
        private int depBreakup=67;
        private int depNotBreakup=50;
        private int breakupTotal=689;
        // Trouble with teacher
        private int notDepTroubleWithTeacher=364;
        private int notDepNotTroubleWithTeacher=209;
        private int depTroubleWithTeacher=66;
        private int depNotTroubleWithTeacher=51;
        private int troubleWithTeacherTotal=690;
        // Trouble with siblings
        private int notDepTroubleWithSiblings=422;
        private int notDepNotTroubleWithSiblings=151;
        private int depTroubleWithSiblings=63;
        private int depNotTroubleWithSiblings=54;
        private int troubleWithSiblingsTotal=690;
        // Loosing close friend
        private int notDepLoosingFriend=433;
        private int notDepNotLoosingFriend=141;
        private int depLoosingFriend=70;
        private int depNotLoosingFriend=47;
        private int loosingFriendTotal=691;
        // Arguing more with parents
        private int notDepArguingWithParents=460;
        private int notDepNotArguingWithParents=113;
        private int depArguingWithParents=58;
        private int depNotArguingWithParents=59;
        private int arguingWithParentsTotal=690;
        // Rating general standard of living
        private int notDepBelowAverage=24;
        private int notDepAverage=256;
        private int notDepAboveAverage=290;
        private int depBelowAverage=16;
        private int depAverage=51;
        private int depAboveAverage=49;
        private int livingStandardTotal=686;

        private double score;

        // User info
        private int age = 16;
        private String gender = "male";
        private String parentsMaritalStatus = "married";
        private boolean smoking = false;
        private boolean alcohol = true;
        private boolean troubleWithClassmates = false;
        private boolean familyMemberIll = true;
        private boolean parentsArguing = false;
        private boolean seriouslyIll = true;
        private boolean breakup = false;
        private boolean troubleWithTeacher = true;
        private boolean troubleWithSiblings = true;
        private boolean loosingFriend = true;
        private boolean arguingWithParents = false;
        private String livingStandard = "average";

        // Constructor
        public DepressionData() {    }


        public Map<String, Object> dataUpdate() {
            Map<String, Object> map = new HashMap<>();

            // Depressed
            if(score >= 14){
                // Age

                map.put("ageTotal", ageTotal + 1);
                if(age<=14){
                    map.put("depFourteen", depFourteen + 1);
                }else if(age == 15){
                    map.put("depFifteen", depFifteen + 1);
                }else if(age == 16){
                    map.put("depSixteen", depSixteen + 1);
                }else{
                    map.put("depSeventeen", depSeventeen + 1);
                }

                // Gender
                map.put("genderTotal",genderTotal + 1);
                if(gender.equalsIgnoreCase("male")){
                    map.put("depMale" , depMale + 1);
                }else{
                    map.put("depFemale", depFemale + 1);
                }

                // Parents' marital status
                map.put("maritalStatusTotal", maritalStatusTotal +1 );

                if(parentsMaritalStatus.equalsIgnoreCase("married")){
                    map.put("depMarried", depMarried + 1);
                }else if(parentsMaritalStatus.equalsIgnoreCase("divorced")){
                    map.put("depDivorced", depDivorced + 1);
                }else{
                    map.put("depWidowed", depWidowed + 1);
                }

                // Smoking
                map.put("smokingTotal", smokingTotal + 1);
                if(smoking){
                    map.put("depSmoking", depSmoking + 1);
                }else{
                    map.put("depNotSmoking", depNotSmoking + 1);
                }

                // Alcohol
                map.put("alcoholTotal", alcoholTotal + 1);
                if(alcohol){
                    map.put("depAlcohol", depAlcohol + 1);
                }else{
                    map.put("depNotAlcohol", depNotAlcohol + 1);
                }

                // Trouble with classmates
                map.put("troubleClassmatesTotal", troubleClassmatesTotal + 1);
                if(isTroubleWithClassmates()){
                    map.put("depTroubleClassmates", depTroubleClassmates + 1);
                }else{
                    map.put("depNotTroubleClassmates", depNotTroubleClassmates + 1);
                }

                // Family member seriously ill
                map.put("familyIllTotal", familyIllTotal + 1);
                if(familyMemberIll){
                    map.put("depFamilyIll", depFamilyIll + 1);
                }else{
                    map.put("depNotFamilyIll", depNotFamilyIll + 1);
                }

                // Parents arduing with each other
                map.put("parentsArguingTotal", parentsArguingTotal + 1);
                if(parentsArguing){
                    map.put("depParentsArguing", depParentsArguing + 1);
                }else{
                    map.put("depNotParentsArguing", depNotParentsArguing + 1);
                }

                // Being seriously ill or injured
                map.put("seriouslyIllTotal", seriouslyIllTotal + 1);
                if(seriouslyIll){
                    map.put("depSeriouslyIll", depSeriouslyIll + 1);
                }else{
                    map.put("depNotSeriouslyIll", depNotSeriouslyIll + 1);
                }

                // Break up with lover
                map.put("breakupTotal", breakupTotal + 1);
                if(breakup){
                    map.put("depBreakup", depBreakup + 1);
                }else{
                    map.put("depNotBreakup", depNotBreakup + 1);
                }

                // Trouble with teacher
                map.put("troubleWithTeacherTotal", troubleWithTeacherTotal + 1);
                if(troubleWithTeacher){
                    map.put("depTroubleWithTeacher", depTroubleWithTeacher + 1 );
                }else{
                    map.put("depNotTroubleWithTeacher", depNotTroubleWithTeacher + 1);
                }

                // Trouble with siblings
                map.put("troubleWithSiblingsTotal" , troubleWithSiblingsTotal + 1);
                if(troubleWithSiblings){
                    map.put("depTroubleWithSiblings", depTroubleWithSiblings + 1);
                }else{
                    map.put("depNotTroubleWithSiblings", depNotTroubleWithSiblings + 1);
                }

                // Loosing close friend
                map.put("loosingFriendTotal", loosingFriendTotal + 1);
                if(loosingFriend){
                    map.put("depLoosingFriend", depLoosingFriend + 1);
                }else{
                    map.put("depNotLoosingFriend", depNotLoosingFriend + 1);
                }

                // Arguing more with parents
                map.put("arguingWithParentsTotal", arguingWithParentsTotal + 1);
                if(arguingWithParents){
                    map.put("depArguingWithParents", depArguingWithParents + 1);
                }else{
                    map.put("depNotArguingWithParents", depNotArguingWithParents + 1);
                }

                // Rating general standard of living
                map.put("livingStandardTotal", livingStandardTotal + 1);
                if (livingStandard.equalsIgnoreCase("above Average")) {
                    map.put("depAboveAverage", depAboveAverage + 1);
                }else if(livingStandard.equalsIgnoreCase("average")){
                    map.put("depAverage", depAverage + 1);
                }else{
                    map.put("depBelowAverage", depBelowAverage + 1);
                }
                // When not depressed
            }else{
                // Age
                map.put("ageTotal", ageTotal + 1);
                if(age<=14){
                    map.put("notDepFourteen", notDepFourteen + 1);
                }else if(age == 15){
                    map.put("notDepFifteen", notDepFifteen + 1);
                }else if(age == 16){
                    map.put("notDepSixteen", notDepSixteen + 1);
                }else{
                    map.put("notDepSeventeen", notDepSeventeen + 1);
                }

                // Gender
                map.put("genderTotal",genderTotal + 1);
                if(gender.equalsIgnoreCase("male")){
                    map.put("notDepMale" , notDepMale + 1);
                }else{
                    map.put("notDepFemale", notDepFemale + 1);
                }

                // Parents' marital status
                map.put("maritalStatusTotal", maritalStatusTotal +1 );

                if(parentsMaritalStatus.equalsIgnoreCase("married")){
                    map.put("notDepMarried", notDepMarried + 1);
                }else if(parentsMaritalStatus.equalsIgnoreCase("divorced")){
                    map.put("notDepDivorced", notDepDivorced + 1);
                }else{
                    map.put("notDepWidowed", notDepWidowed + 1);
                }

                // Smoking
                map.put("smokingTotal", smokingTotal + 1);
                if(smoking){
                    map.put("notDepSmoking", notDepSmoking + 1);
                }else{
                    map.put("notDepNotSmoking", notDepNotSmoking + 1);
                }

                // Alcohol
                map.put("alcoholTotal", alcoholTotal + 1);
                if(alcohol){
                    map.put("notDepAlcohol", notDepAlcohol + 1);
                }else{
                    map.put("notDepNotAlcohol", notDepNotAlcohol + 1);
                }

                // Trouble with classmates
                map.put("troubleClassmatesTotal", troubleClassmatesTotal + 1);
                if(troubleWithClassmates){
                    map.put("notDepTroubleClassmates", notDepTroubleClassmates + 1);
                }else{
                    map.put("notDepNotTroubleClassmates", notDepNotTroubleClassmates + 1);
                }

                // Family member seriously ill
                map.put("familyIllTotal", familyIllTotal + 1);
                if(familyMemberIll){
                    map.put("notDepFamilyIll", notDepFamilyIll + 1);
                }else{
                    map.put("notDepNotFamilyIll", notDepNotFamilyIll + 1);
                }

                // Parents arduing with each other
                map.put("parentsArguingTotal", parentsArguingTotal + 1);
                if(parentsArguing){
                    map.put("notDepParentsArguing", notDepParentsArguing + 1);
                }else{
                    map.put("notDepNotParentsArguing", notDepNotParentsArguing + 1);
                }

                // Being seriously ill or injured
                map.put("seriouslyIllTotal", seriouslyIllTotal + 1);
                if(seriouslyIll){
                    map.put("notDepSeriouslyIll", notDepSeriouslyIll + 1);
                }else{
                    map.put("notDepNotSeriouslyIll", notDepNotSeriouslyIll + 1);
                }

                // Break up with lover
                map.put("breakupTotal", breakupTotal + 1);
                if(breakup){
                    map.put("notDepBreakup", notDepBreakup + 1);
                }else{
                    map.put("notDepNotBreakup", notDepNotBreakup + 1);
                }

                // Trouble with teacher
                map.put("troubleWithTeacherTotal", troubleWithTeacherTotal + 1);
                if(troubleWithTeacher){
                    map.put("notDepTroubleWithTeacher", notDepTroubleWithTeacher + 1 );
                }else{
                    map.put("notDepNotTroubleWithTeacher", notDepNotTroubleWithTeacher + 1);
                }

                // Trouble with siblings
                map.put("troubleWithSiblingsTotal" , troubleWithSiblingsTotal + 1);
                if(troubleWithSiblings){
                    map.put("notDepTroubleWithSiblings", notDepTroubleWithSiblings + 1);
                }else{
                    map.put("notDepNotTroubleWithSiblings", notDepNotTroubleWithSiblings + 1);
                }

                // Loosing close friend
                map.put("loosingFriendTotal", loosingFriendTotal + 1);
                if(loosingFriend){
                    map.put("notDepLoosingFriend", notDepLoosingFriend + 1);
                }else{
                    map.put("notDepNotLoosingFriend", notDepNotLoosingFriend + 1);
                }

                // Arguing more with parents
                map.put("arguingWithParentsTotal", arguingWithParentsTotal + 1);
                if(arguingWithParents){
                    map.put("notDepArguingWithParents", notDepArguingWithParents + 1);
                }else{
                    map.put("notDepNotArguingWithParents", notDepNotArguingWithParents + 1);
                }

                // Rating general standard of living
                map.put("livingStandardTotal", livingStandardTotal + 1);
                if (livingStandard.equalsIgnoreCase("above Average")) {
                    map.put("notDepAboveAverage", notDepAboveAverage + 1);
                }else if(livingStandard.equalsIgnoreCase("average")){
                    map.put("notDepAverage", notDepAverage + 1);
                }else{
                    map.put("notDepBelowAverage", notDepBelowAverage + 1);
                }
            }


            return map;
        }
        public double depProbability(){
            double result = depAge();
            result += depGender();
            result += depParentsMaritalStatus();
            result += depSmoking();
            result += depAlcohol();
            result += depTroubleWithClassmates();
            result += depFamilyMemberIll();
            result += depParentsArguing();
            result += depSeriouslyIll();
            result += depBreakup();
            result += depTroubleWithTeacher();
            result += depTroubleWithSiblings();
            result += depLoosingFriend();
            result += depArguingWithParents();
            result += depLivingStandard();

            return result;
        }

        public double notDepProbability(){
            double result = notDepAge();
            result += notDepGender();
            result += notDepParentsMaritalStatus();
            result += notDepSmoking();
            result += notDepAlcohol();
            result += notDepTroubleWithClassmates();
            result += notDepFamilyMemberIll();
            result += notDepParentsArguing();
            result += notDepSeriouslyIll();
            result += notDepBreakup();
            result += notDepTroubleWithTeacher();
            result += notDepTroubleWithSiblings();
            result += notDepLoosingFriend();
            result += notDepArguingWithParents();
            result += notDepLivingStandard();

            return result;
        }

        private double depLivingStandard(){
            if(livingStandard.equalsIgnoreCase("above average")){
                double depressed = (double)(depAboveAverage + depAverage + depBelowAverage) / livingStandardTotal;
                double aboveAverageDepressed = (double)depAboveAverage / (depAboveAverage + depAverage + depBelowAverage);
                double aboveAverage = (double)(notDepAboveAverage + depAboveAverage) / livingStandardTotal;
                return depressed * aboveAverageDepressed / aboveAverage;
            }else if(livingStandard.equalsIgnoreCase("average")){
                double depressed = (double)(depAboveAverage + depAverage + depBelowAverage) / livingStandardTotal;
                double averageDepressed = (double)depAverage / (depAboveAverage + depAverage + depBelowAverage);
                double average = (double)(notDepAverage + depAverage) / livingStandardTotal;
                return depressed * averageDepressed / average;
            }else{
                double depressed = (double)(depAboveAverage + depAverage + depBelowAverage) / livingStandardTotal;
                double belowAverageDepressed = (double)depBelowAverage / (depAboveAverage + depAverage + depBelowAverage);
                double belowAverage = (double)(notDepBelowAverage + depBelowAverage) / livingStandardTotal;
                return depressed * belowAverageDepressed / belowAverage;
            }
        }
        private double notDepLivingStandard(){
            if(livingStandard.equalsIgnoreCase("above average")){
                double notDepressed = (double)(notDepAboveAverage + notDepAverage + notDepBelowAverage) / livingStandardTotal;
                double aboveAverageNotDepressed = (double)notDepAboveAverage / (notDepAboveAverage + notDepAverage + notDepBelowAverage);
                double aboveAverage = (double)(notDepAboveAverage + notDepAboveAverage) / livingStandardTotal;
                return notDepressed * aboveAverageNotDepressed / aboveAverage;

            }else if(livingStandard.equalsIgnoreCase("average")){
                double notDepressed = (double)(notDepAboveAverage + notDepAverage + notDepBelowAverage) / livingStandardTotal;
                double averageNotDepressed = (double)notDepAverage / (notDepAboveAverage + notDepAverage + notDepBelowAverage);
                double average = (double)(notDepAverage + notDepAverage) / livingStandardTotal;
                return notDepressed * averageNotDepressed / average;

            }else{
                double notDepressed = (double)(notDepAboveAverage + notDepAverage + notDepBelowAverage) / livingStandardTotal;
                double belowAverageNotDepressed = (double)notDepBelowAverage / (notDepAboveAverage + notDepAverage + notDepBelowAverage);
                double belowAverage = (double)(notDepBelowAverage + notDepBelowAverage) / livingStandardTotal;
                return notDepressed * belowAverageNotDepressed / belowAverage;
            }
        }

        private double depArguingWithParents() {
            if (arguingWithParents) {
                double depressed = (double)(depArguingWithParents + depNotArguingWithParents) / arguingWithParentsTotal;
                double arguingWithParentsDepressed = (double)depArguingWithParents / (depArguingWithParents + depNotArguingWithParents);
                double arguingWithParents = (double)(notDepArguingWithParents + depArguingWithParents) / arguingWithParentsTotal;
                return depressed * arguingWithParentsDepressed / arguingWithParents;
            } else {
                double depressed = (double)(depArguingWithParents + depNotArguingWithParents) / arguingWithParentsTotal;
                double notArguingWithParentsDepressed = (double)depNotArguingWithParents / (depArguingWithParents + depNotArguingWithParents);
                double notArguingWithParents = (double)(notDepNotArguingWithParents + depNotArguingWithParents) / arguingWithParentsTotal;
                return depressed * notArguingWithParentsDepressed / notArguingWithParents;
            }
        }

        private double notDepArguingWithParents() {
            if (arguingWithParents) {
                double notDepressed = (double)(notDepArguingWithParents + notDepNotArguingWithParents) / arguingWithParentsTotal;
                double arguingWithParentsNotDepressed = (double)notDepLoosingFriend / (notDepLoosingFriend + notDepNotLoosingFriend);
                double arguingWithParents = (double)(notDepLoosingFriend + depLoosingFriend) / loosingFriendTotal;
                return notDepressed * arguingWithParentsNotDepressed / arguingWithParents;
            } else {
                double notDepressed = (double)(notDepArguingWithParents + notDepNotArguingWithParents) / arguingWithParentsTotal;
                double notArguingWithParentsNotDepressed = (double)notDepNotArguingWithParents / (notDepArguingWithParents + notDepNotArguingWithParents);
                double notArguingWithParents = (double)(notDepNotArguingWithParents + depNotArguingWithParents) / arguingWithParentsTotal;
                return notDepressed * notArguingWithParentsNotDepressed / notArguingWithParents;
            }
        }

        private double depLoosingFriend() {
            if (loosingFriend) {
                double depressed = (double)(depLoosingFriend + depNotLoosingFriend) / loosingFriendTotal;
                double loosingFriendDepressed = (double)depLoosingFriend / (depLoosingFriend + depNotLoosingFriend);
                double loosingFriend = (double)(notDepLoosingFriend + depLoosingFriend) / loosingFriendTotal;
                return depressed * loosingFriendDepressed / loosingFriend;
            } else {
                double depressed = (double)(depLoosingFriend + depNotLoosingFriend) / loosingFriendTotal;
                double notLoosingFriendDepressed = (double)depNotLoosingFriend / (depLoosingFriend + depNotLoosingFriend);
                double notLoosingFriend = (double)(notDepNotLoosingFriend + depNotLoosingFriend) / loosingFriendTotal;
                return depressed * notLoosingFriendDepressed / notLoosingFriend;
            }
        }

        private double notDepLoosingFriend() {
            if (loosingFriend) {
                double notDepressed = (double)(notDepLoosingFriend + notDepNotLoosingFriend) / loosingFriendTotal;
                double loosingFriendNotDepressed = (double)notDepLoosingFriend / (notDepLoosingFriend + notDepNotLoosingFriend);
                double loosingFriend = (double)(notDepLoosingFriend + depLoosingFriend) / loosingFriendTotal;
                return notDepressed * loosingFriendNotDepressed / loosingFriend;
            } else {
                double notDepressed = (double)(notDepLoosingFriend + notDepNotLoosingFriend) / loosingFriendTotal;
                double notLoosingFriendNotDepressed = (double)notDepNotLoosingFriend / (notDepLoosingFriend + notDepNotLoosingFriend);
                double notLoosingFriend = (double)(notDepNotLoosingFriend + depNotLoosingFriend) / loosingFriendTotal;
                return notDepressed * notLoosingFriendNotDepressed / notLoosingFriend;
            }
        }


        private double depTroubleWithSiblings() {
            if (troubleWithSiblings) {
                double depressed = (double)(depTroubleWithSiblings + depNotTroubleWithSiblings) / troubleWithSiblingsTotal;
                double troubleWithSiblingsDepressed = (double)depTroubleWithSiblings / (depTroubleWithSiblings + depNotTroubleWithSiblings);
                double troubleWithSiblings = (double)(notDepTroubleWithSiblings + depTroubleWithSiblings) / troubleWithSiblingsTotal;
                return depressed * troubleWithSiblingsDepressed / troubleWithSiblings;
            } else {
                double depressed = (double)(depTroubleWithSiblings + depNotTroubleWithSiblings) / troubleWithSiblingsTotal;
                double notTroubleWithSiblingsDepressed = (double)depNotTroubleWithSiblings / (depTroubleWithSiblings + depNotTroubleWithSiblings);
                double notTroubleWithSiblings = (double)(notDepNotTroubleWithTeacher + depNotTroubleWithTeacher) / troubleWithTeacherTotal;
                return depressed * notTroubleWithSiblingsDepressed / notTroubleWithSiblings;
            }
        }

        private double notDepTroubleWithSiblings() {
            if (troubleWithSiblings) {
                double notDepressed = (double)(notDepTroubleWithSiblings + notDepNotTroubleWithSiblings) / troubleWithSiblingsTotal;
                double troubleWithSiblingsNotDepressed = (double)notDepTroubleWithSiblings / (notDepTroubleWithSiblings + notDepNotTroubleWithSiblings);
                double troubleWithSiblings = (double)(notDepTroubleWithSiblings + depTroubleWithSiblings) / troubleWithSiblingsTotal;
                return notDepressed * troubleWithSiblingsNotDepressed / troubleWithSiblings;
            } else {
                double notDepressed = (double)(notDepTroubleWithSiblings + notDepNotTroubleWithSiblings) / troubleWithSiblingsTotal;
                double notTroubleWithSiblingsNotDepressed = (double)notDepNotTroubleWithSiblings / (notDepTroubleWithSiblings + notDepNotTroubleWithSiblings);
                double notTroubleWithSiblings = (double)(notDepNotTroubleWithSiblings + depNotTroubleWithSiblings) / troubleWithSiblingsTotal;
                return notDepressed * notTroubleWithSiblingsNotDepressed / notTroubleWithSiblings;
            }
        }

        private double depTroubleWithTeacher() {
            if (troubleWithTeacher) {
                double depressed = (double)(depTroubleWithTeacher + depNotTroubleWithTeacher) / troubleWithTeacherTotal;
                double troubleWithTeacherDepressed = (double)depTroubleWithTeacher / (depTroubleWithTeacher + depNotTroubleWithTeacher);
                double troubleWithTeacher = (double)(notDepTroubleWithTeacher + depTroubleWithTeacher) / troubleWithTeacherTotal;
                return depressed * troubleWithTeacherDepressed / troubleWithTeacher;
            } else {
                double depressed = (double)(depTroubleWithTeacher + depNotTroubleWithTeacher) / troubleWithTeacherTotal;
                double notTroubleWithTeacherDepressed = (double)depNotTroubleWithTeacher / (depTroubleWithTeacher + depNotTroubleWithTeacher);
                double notTroubleWithTeacher = (double)(notDepNotTroubleWithTeacher + depNotTroubleWithTeacher) / troubleWithTeacherTotal;
                return depressed * notTroubleWithTeacherDepressed / notTroubleWithTeacher;
            }
        }

        private double notDepTroubleWithTeacher() {
            if (troubleWithTeacher) {
                double notDepressed = (double)(notDepTroubleWithTeacher + notDepNotTroubleWithTeacher) / troubleWithTeacherTotal;
                double troubleWithTeacherNotDepressed = (double)notDepTroubleWithTeacher / (notDepTroubleWithTeacher + notDepNotTroubleWithTeacher);
                double troubleWithTeacher = (double)(notDepTroubleWithTeacher + depTroubleWithTeacher) / troubleWithTeacherTotal;
                return notDepressed * troubleWithTeacherNotDepressed / troubleWithTeacher;
            } else {
                double notDepressed = (double)(notDepTroubleWithTeacher + notDepNotTroubleWithTeacher) / troubleWithTeacherTotal;
                double notTroubleWithTeacherNotDepressed = (double)notDepNotTroubleWithTeacher / (notDepTroubleWithTeacher + notDepNotTroubleWithTeacher);
                double notTroubleWithTeacher = (double)(notDepNotTroubleWithTeacher + depNotTroubleWithTeacher) / troubleWithTeacherTotal;
                return notDepressed * notTroubleWithTeacherNotDepressed / notTroubleWithTeacher;
            }
        }

        private double depBreakup() {
            if (breakup) {
                double depressed = (double)(depBreakup + depNotBreakup) / breakupTotal;
                double breakupDepressed = (double)depBreakup / (depBreakup + depNotBreakup);
                double breakup = (double)(notDepBreakup + depBreakup) / breakupTotal;
                return depressed * breakupDepressed / breakup;
            } else {
                double depressed = (double)(depBreakup + depNotBreakup) / breakupTotal;
                double notBreakupDepressed = (double)depNotBreakup / (depBreakup + depNotBreakup);
                double notBreakup = (double)(notDepNotBreakup + depNotBreakup) / breakupTotal;
                return depressed * notBreakupDepressed / notBreakup;
            }
        }

        private double notDepBreakup() {
            if (breakup) {
                double notDepressed = (double)(notDepBreakup + notDepNotBreakup) / breakupTotal;
                double breakupNotDepressed = (double)notDepBreakup / (notDepBreakup + notDepNotBreakup);
                double breakup = (double)(notDepBreakup + depBreakup) / breakupTotal;
                return notDepressed * breakupNotDepressed / breakup;
            } else {
                double notDepressed = (double)(notDepBreakup + notDepNotBreakup) / breakupTotal;
                double notBreakupNotDepressed = (double)notDepNotBreakup / (notDepBreakup + notDepNotBreakup);
                double notBreakup = (double)(notDepNotBreakup + depNotBreakup) / breakupTotal;
                return notDepressed * notBreakupNotDepressed / notBreakup;
            }
        }

        private double depSeriouslyIll() {
            if (seriouslyIll) {
                double depressed = (double)(depSeriouslyIll + depNotSeriouslyIll) / seriouslyIllTotal;
                double seriouslyIllDepressed = (double)depSeriouslyIll / (depSeriouslyIll + depNotSeriouslyIll);
                double seriouslyIll = (double)(notDepSeriouslyIll + depSeriouslyIll) / seriouslyIllTotal;
                return depressed * seriouslyIllDepressed / seriouslyIll;
            } else {
                double depressed = (double)(depSeriouslyIll + depNotSeriouslyIll) / seriouslyIllTotal;
                double notSeriouslyIllDepressed = (double)depNotSeriouslyIll / (depSeriouslyIll + depNotSeriouslyIll);
                double notSeriouslyIll = (double)(notDepNotSeriouslyIll + depNotSeriouslyIll) / seriouslyIllTotal;
                return depressed * notSeriouslyIllDepressed / notSeriouslyIll;
            }
        }

        private double notDepSeriouslyIll() {
            if (seriouslyIll) {
                double notDepressed = (double)(notDepSeriouslyIll + notDepNotSeriouslyIll) / seriouslyIllTotal;
                double seriouslyIllNotDepressed = (double)notDepSeriouslyIll / (notDepSeriouslyIll + notDepNotSeriouslyIll);
                double seriouslyIll = (double)(notDepSeriouslyIll + depSeriouslyIll) / seriouslyIllTotal;
                return notDepressed * seriouslyIllNotDepressed / seriouslyIll;
            } else {
                double notDepressed = (double)(notDepSeriouslyIll + notDepNotSeriouslyIll) / seriouslyIllTotal;
                double notSeriouslyIllNotDepressed = (double)notDepNotSeriouslyIll / (notDepSeriouslyIll + notDepNotSeriouslyIll);
                double notSeriouslyIll = (double)(notDepNotSeriouslyIll + depNotSeriouslyIll) / seriouslyIllTotal;
                return notDepressed * notSeriouslyIllNotDepressed / notSeriouslyIll;
            }
        }

        private double depParentsArguing() {
            if (parentsArguing) {
                double depressed = (double)(depParentsArguing + depNotParentsArguing) / parentsArguingTotal;
                double parentsArguingDepressed = (double)depParentsArguing / (depParentsArguing + depNotParentsArguing);
                double parentsArguing = (double)(notDepParentsArguing + depParentsArguing) / parentsArguingTotal;
                return depressed * parentsArguingDepressed / parentsArguing;
            } else {
                double depressed = (double)(depParentsArguing + depNotParentsArguing) / parentsArguingTotal;
                double notParentsArguingDepressed = (double)depNotParentsArguing / (depParentsArguing + depNotParentsArguing);
                double notParentsArguing = (double)(notDepNotParentsArguing + depNotParentsArguing) / parentsArguingTotal;
                return depressed * notParentsArguingDepressed / notParentsArguing;
            }
        }

        private double notDepParentsArguing() {
            if (parentsArguing) {
                double notDepressed = (double)(notDepParentsArguing + notDepNotParentsArguing) / parentsArguingTotal;
                double parentsArguingNotDepressed = (double)notDepParentsArguing / (notDepParentsArguing + notDepNotParentsArguing);
                double parentsArguing = (double)(notDepParentsArguing + depParentsArguing) / parentsArguingTotal;
                return notDepressed * parentsArguingNotDepressed / parentsArguing;
            } else {
                double notDepressed = (double)(notDepParentsArguing + notDepNotParentsArguing) / parentsArguingTotal;
                double notParentsArguingNotDepressed = (double)notDepNotParentsArguing / (notDepParentsArguing + notDepNotParentsArguing);
                double notParentsArguing = (double)(notDepNotParentsArguing + depNotParentsArguing) / parentsArguingTotal;
                return notDepressed * notParentsArguingNotDepressed / notParentsArguing;
            }
        }

        private double depFamilyMemberIll() {
            if (familyMemberIll) {
                double depressed = (double)(depFamilyIll + depNotFamilyIll) / familyIllTotal;
                double familyIllDepressed = (double)depFamilyIll / (depFamilyIll + depNotFamilyIll);
                double familyIll = (double)(notDepFamilyIll + depFamilyIll) / familyIllTotal;
                return depressed * familyIllDepressed / familyIll;
            } else {
                double depressed = (double)(depFamilyIll + depNotFamilyIll) / familyIllTotal;
                double notFamilyIllDepressed = (double)depNotFamilyIll / (depFamilyIll + depNotFamilyIll);
                double notFamilyIll = (double)(notDepNotFamilyIll + depNotFamilyIll) / familyIllTotal;
                return depressed * notFamilyIllDepressed / notFamilyIll;
            }
        }

        private double notDepFamilyMemberIll() {
            if (familyMemberIll) {
                double notDepressed = (double)(notDepFamilyIll + notDepNotFamilyIll) / familyIllTotal;
                double familyIllNotDepressed = (double)notDepFamilyIll / (notDepFamilyIll + notDepNotFamilyIll);
                double familyIll = (double)(notDepFamilyIll + depFamilyIll) / familyIllTotal;
                return notDepressed * familyIllNotDepressed / familyIll;
            } else {
                double notDepressed = (double)(notDepFamilyIll + notDepNotFamilyIll) / familyIllTotal;
                double notFamilyIllNotDepressed = (double)notDepNotFamilyIll / (notDepFamilyIll + notDepNotFamilyIll);
                double notFamilyIll = (double)(notDepNotFamilyIll + depNotFamilyIll) / familyIllTotal;
                return notDepressed * notFamilyIllNotDepressed / notFamilyIll;
            }
        }

        private double depTroubleWithClassmates() {
            if (troubleWithClassmates ) {
                double depressed = (double)(depTroubleClassmates + depNotTroubleClassmates) / troubleClassmatesTotal;
                double troubleWithClassmatesDepressed = (double)depTroubleClassmates / (depTroubleClassmates + depNotTroubleClassmates);
                double troubleWithClassmates = (double)(notDepTroubleClassmates + depTroubleClassmates) / troubleClassmatesTotal;
                return depressed * troubleWithClassmatesDepressed / troubleWithClassmates;
            } else {
                double depressed = (double)(depTroubleClassmates + depNotTroubleClassmates) / troubleClassmatesTotal;
                double notTroubleWithClassmatesDepressed = (double)depNotTroubleClassmates/ (depTroubleClassmates + depNotTroubleClassmates);
                double notTroubleWithClassmates = (double)(notDepNotTroubleClassmates + depNotTroubleClassmates) / troubleClassmatesTotal;
                return depressed * notTroubleWithClassmatesDepressed / notTroubleWithClassmates;
            }
        }
        private double notDepTroubleWithClassmates() {
            if (troubleWithClassmates ) {
                double notDepressed = (double)(notDepTroubleClassmates + notDepNotTroubleClassmates) / troubleClassmatesTotal;
                double troubleWithClassmatesNotDepressed = (double)notDepTroubleClassmates / (notDepTroubleClassmates + notDepNotTroubleClassmates);
                double troubleWithClassmates = (double)(notDepTroubleClassmates + depTroubleClassmates) / troubleClassmatesTotal;
                return notDepressed * troubleWithClassmatesNotDepressed / troubleWithClassmates;
            } else {
                double notDepressed = (double)(notDepTroubleClassmates + notDepNotTroubleClassmates) / troubleClassmatesTotal;
                double notTroubleWithClassmatesNotDepressed = (double)notDepNotTroubleClassmates/ (notDepTroubleClassmates + notDepNotTroubleClassmates);
                double notTroubleWithClassmates = (double)(notDepNotTroubleClassmates + depNotTroubleClassmates) / troubleClassmatesTotal;
                return notDepressed * notTroubleWithClassmatesNotDepressed / notTroubleWithClassmates;
            }
        }

        private double depAlcohol() {
            if (alcohol ) {
                double depressed = (double)(depAlcohol + depNotAlcohol) / alcoholTotal;
                double alcoholDepressed = (double)depAlcohol / (depAlcohol + depNotAlcohol);
                double alcohol = (double)(notDepAlcohol + depAlcohol) / alcoholTotal;
                return depressed * alcoholDepressed / alcohol;
            } else {
                double depressed = (double)(depAlcohol + depNotAlcohol) / alcoholTotal;
                double notAlcoholDepressed = (double)depNotAlcohol / (depAlcohol + depNotAlcohol);
                double notAlcohol = (double)(notDepNotAlcohol + depNotAlcohol) / alcoholTotal;
                return depressed * notAlcoholDepressed / notAlcohol;
            }
        }

        private double notDepAlcohol() {
            if (alcohol) {
                double notDepressed = (double)(notDepMale + notDepFemale) / genderTotal;
                double maleNotDepressed = (double)notDepMale / (notDepMale + notDepFemale);
                double male = (double)(notDepMale + depMale) / genderTotal;
                return notDepressed * maleNotDepressed / male;
            } else {
                double notDepressed = (double)(notDepMale + notDepFemale) / genderTotal;
                double femaleNotDepressed = (double)notDepFemale / (notDepMale + notDepFemale);
                double female = (double)(notDepFemale + depFemale) / genderTotal;
                return notDepressed * femaleNotDepressed / female;
            }
        }

        private double depSmoking(){
            if(smoking){
                double depressed = (double)(depSmoking + depNotSmoking) / smokingTotal;
                double smokingDepressed = (double)depSmoking / (depSmoking + depNotSmoking);
                double smoking = (double)(notDepSmoking + depSmoking) / smokingTotal;
                return depressed * smokingDepressed / smoking;
            }else{
                double depressed = (double)(depSmoking + depNotSmoking) / smokingTotal;
                double notSmokingDepressed = (double)depNotSmoking / (depSmoking + depNotSmoking);
                double notSmoking = (double)(notDepNotSmoking + depNotSmoking) / smokingTotal;
                return depressed * notSmokingDepressed / notSmoking;
            }
        }
        private double notDepSmoking(){
            if(smoking){
                double notDepressed = (double)(notDepSmoking + notDepNotSmoking) / smokingTotal;
                double smokingNotDepressed = (double)notDepSmoking / (notDepSmoking + notDepNotSmoking);
                double smoking = (double)(notDepSmoking + depSmoking) / smokingTotal;
                return notDepressed * smokingNotDepressed / smoking;
            }else{
                double notDepressed = (double)(notDepSmoking + notDepNotSmoking) / smokingTotal;
                double notSmokingNotDepressed = (double)notDepNotSmoking / (notDepSmoking + notDepNotSmoking);
                double notSmoking = (double)(notDepNotSmoking + depNotSmoking) / smokingTotal;
                return notDepressed * notSmokingNotDepressed / notSmoking;
            }
        }

        private double depParentsMaritalStatus(){
            if(parentsMaritalStatus.equalsIgnoreCase("married")){
                double depressed = (double)(depMarried + depDivorced + depWidowed) / maritalStatusTotal;
                double marriedDepressed = (double)depMarried / (depMarried + depDivorced + depWidowed);
                double married = (double)(notDepMarried + depMarried) / maritalStatusTotal;
                return depressed * marriedDepressed / married;
            }else if(parentsMaritalStatus.equalsIgnoreCase("divorced")){
                double depressed = (double)(depMarried + depDivorced + depWidowed) / maritalStatusTotal;
                double divorcedDepressed = (double)depDivorced / (depMarried + depDivorced + depWidowed);
                double divorced = (double)(notDepDivorced + depDivorced) / maritalStatusTotal;
                return depressed * divorcedDepressed / divorced;
            }else{
                double depressed = (double)(depMarried + depDivorced + depWidowed) / maritalStatusTotal;
                double widowedDepressed = (double)depWidowed / (depMarried + depDivorced + depWidowed);
                double widowed = (double)(notDepWidowed + depWidowed) / maritalStatusTotal;
                return depressed * widowedDepressed / widowed;
            }
        }

        private double notDepParentsMaritalStatus(){
            if(parentsMaritalStatus.equalsIgnoreCase("married")){
                double notDepressed = (double)(notDepMarried + notDepDivorced + notDepWidowed) / maritalStatusTotal;
                double marriedNotDepressed = (double)notDepMarried / (notDepMarried + notDepDivorced + notDepWidowed);
                double married = (double)(notDepMarried + notDepMarried) / maritalStatusTotal;
                return notDepressed * marriedNotDepressed / married;

            }else if(parentsMaritalStatus.equalsIgnoreCase(("divorced"))){
                double notDepressed = (double)(notDepMarried + notDepDivorced + notDepWidowed) / maritalStatusTotal;
                double divorcedNotDepressed = (double)notDepDivorced / (notDepMarried + notDepDivorced + notDepWidowed);
                double divorced = (double)(notDepDivorced + notDepDivorced) / maritalStatusTotal;
                return notDepressed * divorcedNotDepressed / divorced;

            }else{
                double notDepressed = (double)(notDepMarried + notDepDivorced + notDepWidowed) / maritalStatusTotal;
                double widowedNotDepressed = (double)notDepWidowed / (notDepMarried + notDepDivorced + notDepWidowed);
                double widowed = (double)(notDepWidowed + notDepWidowed) / maritalStatusTotal;
                return notDepressed * widowedNotDepressed / widowed;
            }
        }

        private double depAge(){
            if(age <= 14){
                double depressed = (double)(depFourteen + depFifteen + depSixteen + depSeventeen) / ageTotal;
                double fourteenDepressed = (double)depFourteen / (depFourteen + depFifteen + depSixteen + depSeventeen);
                double fourteen = (double)(notDepFourteen + depFourteen) / ageTotal;
                return depressed * fourteenDepressed / fourteen;

            }else if(age == 15){
                double depressed = (double)(depFourteen + depFifteen + depSixteen + depSeventeen) / ageTotal;
                double fifteenDepressed = (double)depFifteen / (depFourteen + depFifteen + depSixteen + depSeventeen);
                double fifteen = (double)(notDepFifteen + depFifteen) / ageTotal;
                return depressed * fifteenDepressed / fifteen;

            }else if(age == 16){
                double depressed = (double)(depFourteen + depFifteen + depSixteen + depSeventeen) / ageTotal;
                double sixteenDepressed = (double)depSixteen / (depFourteen + depFifteen + depSixteen + depSeventeen);
                double sixteen = (double)(notDepSixteen + depSixteen) / ageTotal;
                return depressed * sixteenDepressed / sixteen;

            }else{
                double depressed = (double)(depFourteen + depFifteen + depSixteen + depSeventeen) / ageTotal;
                double seventeenDepressed = (double)depSeventeen / (depFourteen + depFifteen + depSixteen + depSeventeen);
                double seventeen = (double)(notDepSeventeen + depSeventeen) / ageTotal;
                return depressed * seventeenDepressed / seventeen;
            }
        }
        private double notDepAge(){
            if(age <= 14){
                double notDepressed = (double)(notDepFourteen + notDepFifteen + notDepSixteen + notDepSeventeen) / ageTotal;
                double fourteenNotDepressed = (double)notDepFourteen / (notDepFourteen + notDepFifteen + notDepSixteen + notDepSeventeen);
                double fourteen = (double)(notDepFourteen + depFourteen) / ageTotal;
                return notDepressed * fourteenNotDepressed / fourteen;

            }else if(age == 15){
                double notDepressed = (double)(notDepFourteen + notDepFifteen + notDepSixteen + notDepSeventeen) / ageTotal;
                double fifteenNotDepressed = (double)notDepFifteen / (notDepFourteen + notDepFifteen + notDepSixteen + notDepSeventeen);
                double fifteen = (double)(notDepFifteen + depFifteen) / ageTotal;
                return notDepressed * fifteenNotDepressed / fifteen;

            }else if(age == 16){
                double notDepressed = (double)(notDepFourteen + notDepFifteen + notDepSixteen + notDepSeventeen) / ageTotal;
                double sixteenNotDepressed = (double)depSixteen / (notDepFourteen + notDepFifteen + notDepSixteen + notDepSeventeen);
                double sixteen = (double)(notDepSixteen + depSixteen) / ageTotal;
                return notDepressed * sixteenNotDepressed / sixteen;

            }else{
                double notDepressed = (double)(notDepFourteen + notDepFifteen + notDepSixteen + notDepSeventeen) / ageTotal;
                double seventeenNotDepressed = (double)depSeventeen / (notDepFourteen + notDepFifteen + notDepSixteen + notDepSeventeen);
                double seventeen = (double)(notDepSeventeen + depSeventeen) / ageTotal;
                return notDepressed * seventeenNotDepressed / seventeen;
            }
        }

        private double depGender() {
            if (gender.equalsIgnoreCase("male")) {
                double depressed = (double)(depMale + depFemale) / genderTotal;
                double maleDepressed = (double)depMale / (depMale + depFemale);
                double male = (double)(notDepMale + depMale) / genderTotal;
                return depressed * maleDepressed / male;
            } else {
                double depressed = (double)(depMale + depFemale) / genderTotal;
                double femaleDepressed = (double)depFemale / (depMale + depFemale);
                double female = (double)(notDepFemale + depFemale) / genderTotal;
                return depressed * femaleDepressed / female;
            }
        }

        private double notDepGender() {
            if (gender.equalsIgnoreCase("male")) {
                double notDepressed = (double)(notDepMale + notDepFemale) / genderTotal;
                double maleNotDepressed = (double)notDepMale / (notDepMale + notDepFemale);
                double male = (double)(notDepMale + depMale) / genderTotal;
                return notDepressed * maleNotDepressed / male;
            } else {
                double notDepressed = (double)(notDepMale + notDepFemale) / genderTotal;
                double femaleNotDepressed = (double)notDepFemale / (notDepMale + notDepFemale);
                double female = (double)(notDepFemale + depFemale) / genderTotal;
                return notDepressed * femaleNotDepressed / female;
            }
        }

        public int getNotDepFourteen() {
            return notDepFourteen;
        }

        public int getNotDepFifteen() {
            return notDepFifteen;
        }

        public int getNotDepSixteen() {
            return notDepSixteen;
        }

        public int getNotDepSeventeen() {
            return notDepSeventeen;
        }

        public int getDepFourteen() {
            return depFourteen;
        }

        public int getDepFifteen() {
            return depFifteen;
        }

        public int getDepSixteen() {
            return depSixteen;
        }

        public int getDeoSeventeen() {
            return depSeventeen;
        }

        public int getAgeTotal() {
            return ageTotal;
        }

        public int getNotDepMale() {
            return notDepMale;
        }

        public int getNotDepFemale() {
            return notDepFemale;
        }

        public int getDepMale() {
            return depMale;
        }

        public int getDepFemale() {
            return depFemale;
        }

        public int getGenderTotal() {
            return genderTotal;
        }

        public int getNotDepMarried() {
            return notDepMarried;
        }

        public int getNotDepDivorced() {
            return notDepDivorced;
        }

        public int getNotDepWidowed() {
            return notDepWidowed;
        }

        public int getDepMarried() {
            return depMarried;
        }

        public int getDepDivorced() {
            return depDivorced;
        }

        public int getDepWidowed() {
            return depWidowed;
        }

        public int getMaritalStatusTotal() {
            return maritalStatusTotal;
        }

        public int getNotDepSmoking() {
            return notDepSmoking;
        }

        public int getNotDepNoSmoking() {
            return notDepNotSmoking;
        }

        public int getDepSmoking() {
            return depSmoking;
        }

        public int getDepNotSmoking() {
            return depNotSmoking;
        }

        public int getSmokingTotal() {
            return smokingTotal;
        }

        public int getNotDepAlcohol() {
            return notDepAlcohol;
        }

        public int getNotDepNotAlcohol() {
            return notDepNotAlcohol;
        }

        public int getDepAlcohol() {
            return depAlcohol;
        }

        public int getDepNotAlcohol() {
            return depNotAlcohol;
        }

        public int getAlcoholTotal() {
            return alcoholTotal;
        }

        public int getNotDepTroubleClassmates() {
            return notDepTroubleClassmates;
        }

        public int getNotDepNotTroubleClassmates() {
            return notDepNotTroubleClassmates;
        }

        public int getDepTroubleClassmates() {
            return depTroubleClassmates;
        }

        public int getDepNotTroubleClassmates() {
            return depNotTroubleClassmates;
        }

        public int getTroubleClassmatesTotal() {
            return troubleClassmatesTotal;
        }

        public int getNotDepFamilyIll() {
            return notDepFamilyIll;
        }

        public int getNotDepNotFamilyIll() {
            return notDepNotFamilyIll;
        }

        public int getDepFamilyIll() {
            return depFamilyIll;
        }

        public int getDepNotFamilyIll() {
            return depNotFamilyIll;
        }

        public int getFamilyIllTotal() {
            return familyIllTotal;
        }

        public int getNotDepParentsArguing() {
            return notDepParentsArguing;
        }

        public int getNotDepNotParentsArguing() {
            return notDepNotParentsArguing;
        }

        public int getDepParentsArguing() {
            return depParentsArguing;
        }

        public int getDepNotParentsArguing() {
            return depNotParentsArguing;
        }

        public int getParentsArguingTotal() {
            return parentsArguingTotal;
        }

        public int getNotDepSeriouslyIll() {
            return notDepSeriouslyIll;
        }

        public int getNorDepNotSeriouslyIll() {
            return notDepNotSeriouslyIll;
        }

        public int getDepSeriouslyIll() {
            return depSeriouslyIll;
        }

        public int getDepNotSeriouslyIll() {
            return depNotSeriouslyIll;
        }

        public int getSeriouslyIllTotal() {
            return seriouslyIllTotal;
        }

        public int getNotDepBreakup() {
            return notDepBreakup;
        }

        public int getNotNotDepBreakup() {
            return notDepNotBreakup;
        }

        public int getDepBreakup() {
            return depBreakup;
        }

        public int getDepNotBreakup() {
            return depNotBreakup;
        }

        public int getBreakupTotal() {
            return breakupTotal;
        }

        public int getNotDepTroubleWithTeacher() {
            return notDepTroubleWithTeacher;
        }

        public int getNotDepNotTroubleWithTeacher() {
            return notDepNotTroubleWithTeacher;
        }

        public int getDepTroubleWithTeacher() {
            return depTroubleWithTeacher;
        }

        public int getDepNotTroubleWithTeacher() {
            return depNotTroubleWithTeacher;
        }

        public int getTroubleWithTeacherTotal() {
            return troubleWithTeacherTotal;
        }

        public int getNotDepTroubleWithSiblings() {
            return notDepTroubleWithSiblings;
        }

        public int getNotDepNotTroubleWithSiblings() {
            return notDepNotTroubleWithSiblings;
        }

        public int getDepTroubleWithSiblings() {
            return depTroubleWithSiblings;
        }

        public int getDepNotTroubleWithSiblings() {
            return depNotTroubleWithSiblings;
        }

        public int getTroubleWithSiblingsTotal() {
            return troubleWithSiblingsTotal;
        }

        public int getNotDepLoosingFriend() {
            return notDepLoosingFriend;
        }

        public int getNotDepNotLoosingFriend() {
            return notDepNotLoosingFriend;
        }

        public int getDepLoosingFriend() {
            return depLoosingFriend;
        }

        public int getDepNotLoosingFriend() {
            return depNotLoosingFriend;
        }

        public int getLoosingFriendTotal() {
            return loosingFriendTotal;
        }

        public int getNotDepArguingWithParents() {
            return notDepArguingWithParents;
        }

        public int getNotDepNotArguingWithParents() {
            return notDepNotArguingWithParents;
        }

        public int getDepArguingWithParents() {
            return depArguingWithParents;
        }

        public int getDepNotArguingWithParents() {
            return depNotArguingWithParents;
        }

        public int getArguingWithParentsTotal() {
            return arguingWithParentsTotal;
        }

        public int getNotDepBelowAverage() {
            return notDepBelowAverage;
        }

        public int getNotDepAverage() {
            return notDepAverage;
        }

        public int getNotDepAboveAverage() {
            return notDepAboveAverage;
        }

        public int getDepBelowAverage() {
            return depBelowAverage;
        }

        public int getDepAverage() {
            return depAverage;
        }

        public int getDepAboveAverage() {
            return depAboveAverage;
        }

        public int getLivingStandardTotal() {
            return livingStandardTotal;
        }
        public double getScore(){
            return score;
        }
        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        public String getParentsMaritalStatus() {
            return parentsMaritalStatus;
        }

        public boolean isSmoking() {
            return smoking;
        }

        public boolean isAlcohol() {
            return alcohol;
        }

        public boolean isTroubleWithClassmates() {
            return troubleWithClassmates;
        }

        public boolean isFamilyMemberIll() {
            return familyMemberIll;
        }

        public boolean isParentsArguing() {
            return parentsArguing;
        }

        public boolean isSeriouslyIll() {
            return seriouslyIll;
        }

        public boolean isBreakup() {
            return breakup;
        }

        public boolean isTroubleWithTeacher() {
            return troubleWithTeacher;
        }

        public boolean isTroubleWithSiblings() {
            return troubleWithSiblings;
        }

        public boolean isLoosingFriend() {
            return loosingFriend;
        }

        public boolean isArguingWithParents() {
            return arguingWithParents;
        }

        public String getLivingStandard() {
            return livingStandard;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

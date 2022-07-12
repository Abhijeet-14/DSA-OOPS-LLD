//package _dsa;
//
//public class Amazon_R2 {
//}
///*
//Given a list of people with their birth and death years, implement a method to compute the year with most number of people alive.
//You may assume that all people were born between 1900 - 2000 (inclusive).
//
//If a person was alive during any portion of that year, they should be included in that years count.
//For example, Person(birth = 1908, death = 1909) is included in the counts for both 1908 and 1909
//*/
//// example input: [[1905,1950],[1906,1955],[1980,2000]]
//// [[1906,1955],[1980,2000], [1905,1950]]
////1900 to 1910
//// {P()
//// example 2:[[1900,1910], [1905,1909], [1904,1906]]
//// W|Expected Output: 1905 - max 3 people alive
//// Input might not be in Sorted order
//
//// b - 1900, 1905, 1904
//// d - 1910, 1909, 1950
//
//// 1900 - 3, 2
////N - N
////        M - 2
////        N*M - Nx2
//
//// Hint: [1,0,0,0,1,1,-1,0,0,-1,-1]
//// 1900 -1902 -> sum - 1
//// 1905 -
//
//// camelCase
//public static int solve(int peopleBirthYearAndDeathYear[][], int startYear, int endYear, int checkInYear){
//
//        int rangeOfYear = endYear - startYear;
//        int lengthOFPeopleBirthYearAndDeathYear = peopleBirthYearAndDeathYear.length;
//        if(lengthOFPeopleBirthYearAndDeathYear == 0)
//        return 0;
//
//
//        int countOfAlivePeople[] = new int[rangeOfYear]
//        Arrays.fill(countOfAlivePeople, 0);
//        for(int index=0; index<lengthOFPeopleBirthYearAndDeathYear; index++){
//        // for(int idx=0; idx<2; idx++){
//        int birthYear = peopleBirthYearAndDeathYear[index][0];
//        int deathYear = peopleBirthYearAndDeathYear[index][1];
//        countOfAlivePeople[birthYear-1] += 1;
//        countOfAlivePeople[deathYear-1] -= 1;
//        // }
//        }
//
//        int maxPeopleAlive = 0;
//        int maxAtYear = 0
//        int whichYear = 0;
//        int currentSum = 0
//        for(int index=0; index<rangeOfYear; index++){
//        if(index==checkInYear-1)
//        return maxPeopleAlive;
//        else{
//        maxPeopleAlive += countOfAlivePeople[index];
//        }
//        }
//        }
//
//
//
///* For two arrays a and b, each of the same size, array correlation is the sum of all b[i] where b[i] > a[i].
//
//Given two arrays of integers a and b, rearrange the elements of b such that the array correlation is maximum.
//
//Note: that it is not allowed to rearrange elements of the array a.
//n = 5, a = [1, 2, 3, 4, 5],
//       b = [3, 5, 4, 6, 2]
//
//
//a = [1, 9, 4, 2]
//b = [8, 4, 3, 1]
//
//*/
//        a = [1, 9, 4, 2]
//        b = [8, 4, 3, 1]
//// [1,3,4,8]
//// [9,4,2,1]
//// [3,1,8, 4]
//
//// sort the b - array - NlogN
//// find nearestGreaterElement to a[i] in b[] - N*logN
//// 1,9,4,2
//// 3, -1, 8, 4
//// sum - N
//// TC - NLogN
//
//public int solve(int a[], int b[]){
//        int sum = 0;
//        int n = b.length;
//        if(a.length != b.length)
//        return sum;
//
//        Arrays.sort(b);
//
//
//        int visited[] =new int[n];
//
//        int correltedB[] = new int[n];
//
//        for(int idx=0; idx<n;idx++){
//        nextGreaterElement(a[idx], b, visited);
//        }
//        }
//
//public int nextGreaterElement(int val, int arr[], int vistited[]){
//        int start =0;
//        int end = arr.length;
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

package _dsa._java;

public class Q1_FreshWorks {
	
	// Question 1:
	// o(N)... by traversing
	// newStr = "olleh"..
	
	// hello.. i=0 & j=length-1... 
	// i++ & j--
	// i < j
	// i=0, j=4.. h & o
	// i=1, j=3, . e & l
	// i=2, j=2.. l & l
	
	//	helloo
	// i=0, & j=5... h & o
	// i=1 & j=4.. o & e
	// i=2 & j=3.. l & l
	
	// Q2
	
	// s = "aabjrrf"
	// a =2
	// b = 1
	// j= 1
	// r = 2
	// f=1
	// a r .. & b j f
	// while(i< repeat.length && j < single.length)
	// a.. DECREASE the count a--... if(count_a == 0) i++
	// b.. increase j++
	
	// while(i<repeat.length)
	// a.. DECREASE the count a--... if(count_a == 0) i++
	
//	while(j<single.repeat){
//		f... j++
	
	// String = answer
	// repeat[] = {a, r} // {3, 2}
	// single[] = {b, j, f}
//	i =0; & j =0;
	// while(i< repeat.length && j < single.length){
	//  i=0.. answer += a;	count_a -- // count_a = 1
	// if(count_a == 0) i++;
	//
	// answer += b.. j++
							// answer = ab
	// i=0
	// answer += a.. count_a --; //count_a =0			// answer = aba
	// if(count_a == 0) i++
	//	
	// }
	
	
	// Q3:
	// '1' === 1 ..
	// '1' == 1 ..
	// Select name from Student where (select Max(marks) from Student)
	// select name from student ON JOIN
	// 100  & 11
	// |  
	// 0 0 = 0
	// 1 0 =1
	// 0 1 = 1
	// 1 1 = 1
	// 100	=> 4			
	// 011	=> 30000000011
//	   111	=> 7
	
	
	public static void main(String[] args) {
		
	}
}

import java.util.Scanner;

import java.util.ArrayList;
public class ReqDep {
	   public static void main(String[] args) {
		 
		Scanner kb = new Scanner(System.in);

		 
        ArrayList<String> Reqs = new ArrayList<String>();
      

        System.out.print("Please Enter the number of requirements: ");
        int numOfRequirements = kb.nextInt();
        kb.nextLine();

        for (int i = 1; i <= numOfRequirements; i++) {
            System.out.print("Please Enter requirement " + (i) + ": ");
            String Req = kb.nextLine();
            Reqs.add(Req);
        }

        
       boolean[][]  dependencyMatrix = new boolean[numOfRequirements][numOfRequirements]; // we make a 2 dimensional  array with the size of the numOfRequirements
       
        System.out.println("Please Enter the dependency between the requirements: ");	
        
        while (true) {
            String input = kb.nextLine();
            if (input.equals("0")) {
                break;
            }
            String[] getDependencies = input.split(" ");
            String dependentRequirement = getDependencies[0];
            for (int i = 1; i < getDependencies.length; i++) {
                String dependency = getDependencies[i];
                int getIndexOfRequirement = Reqs.indexOf(dependentRequirement);
                int getIndexOfDependency = Reqs.indexOf(dependency);
                dependencyMatrix[getIndexOfRequirement][getIndexOfDependency] = true;
            }
        }
        

            
   
            
        System.out.println("Dependency Matrix :");
        System.out.print("  ");
        for (String Req : Reqs) {
            System.out.print(Req + " ");
        }
        System.out.println();
        for (int i = 0; i < numOfRequirements; i++) {
            System.out.print(Reqs.get(i) + " ");
            for (int j = 0; j < numOfRequirements; j++) {
                if (dependencyMatrix[i][j] == true) {
                    System.out.print("x ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
       }
   
        if (args.length > 0) {
            String commandRequirement = args[0];
            int commandIndex = Reqs.indexOf(commandRequirement);
            if (commandIndex != -1) {
                System.out.println("Dependency level of " + commandRequirement + ":");
                printDependencyLevel(commandIndex, Reqs, dependencyMatrix, 1);
        } else {
                System.out.println("Requirement " + commandRequirement + " not found.");
          }
     }
       
   
}

	   private static void printDependencyLevel(int commandIndex, ArrayList<String> Reqs, boolean[][] dependencyMatrix, int level) {
		   for (int i = 0; i < Reqs.size(); i++) {
		   if (dependencyMatrix[i][commandIndex] == true) {
		   System.out.println(level + " " + Reqs.get(i));
		   printDependencyLevel(i, Reqs, dependencyMatrix, level + 1);
		   }
		   }
		   }
		   }

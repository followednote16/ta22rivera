import java.util.Scanner;
class Main {
 
  public static void main(String[] args) {

    String response;

      Scanner sc = new Scanner(System.in);
      System.out.println("Welcome to Higher or Lower! Select an action: \n \n 1. Play \n 2. Change settings \n 3. End game \n ");

      System.out.print("Action: ");
      response = sc.nextLine();

      int max = 10;
      int min = 1;
      int range = max - min + 1;
      int guesses = 3;

      do{

      switch(response){
        case "1": 

          String repeat;

          do{

            int number;
            
            number = (int) Math.floor(Math.random()*range) + min;

              for(int i = guesses; i > 0; i--){

                int answer;
              
                System.out.print("\nYou have " 
                                   + i 
                                   + " guess/es left. \n\nChoose a number from " 
                                   + min 
                                   + " to " 
                                   + max
                                   + ": ");
                
                answer = Integer.parseInt(sc.nextLine());

                if(i>0){
  
                  if((answer<max+1)&&(answer>min-1)){
                
                    if(answer>number){
                      if(i==1){
                        System.out.print("You lose!!! L");
                          break;
                        }
                        else{
                          System.out.println("\n\nLower!");
                          }
                      }

                    else if(answer<number){
                      if(i==1){
                        System.out.print("\n\nYou lose!!! L\n\n");
                          break;
                        }
                        else{
                          System.out.println("\n\nHigher!");
                          }
                      }

                    else if(answer==number){
                      System.out.print("\n\nCongratulations!! You won!!\n\n");
                      break;
                        }
                  }

                 else{
                  System.out.print("\nInvalid Answer!!\n");
                  break;
                }

                }
                  
                else if(i==0){

                  if(answer!=number){
                  System.out.print("You lose!!! L");
                  break;
                  }
                }
            
          }
            
          System.out.print("\nPlay again? [y/n]: ");
            
          repeat = sc.nextLine();
            
          }while(repeat.equalsIgnoreCase("y"));

          if((repeat!="y")||(repeat!="Y")){
            response = "3";
          }

          break;

        case "2":

          int newMax, newMin, newGuesses;

          System.out.print("\nSet upper limit (default: 10): ");
          newMax = Integer.parseInt(sc.nextLine());

          if(newMax>1){
            
            System.out.print("\nSet lower limit (default: 1): ");
            newMin = Integer.parseInt(sc.nextLine());
            max = newMax;

              if((newMin<newMax)&&(newMin>=0)){

                System.out.print("\nSet max guesses (default: 3): ");
                newGuesses = Integer.parseInt(sc.nextLine());
                min = newMin;

                  if(newGuesses>0){
                    guesses=newGuesses;
                  }else{
                    System.out.print("Invalid Input!");
                    break;
                  }
              }else{
                System.out.print("Invalid Input!");
                break;
              }
          }else{
            System.out.print("Invalid Input!");
            break;
          }

          response="1";

          break;

        case "3":
          break;
          

        default:
          System.out.println("\nInvalid Input!!!!!");
          break;
          
      }

      }while((response=="1")||(response=="2"));

  }
}
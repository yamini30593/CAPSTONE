import java.util.Scanner;

class BloodBank {
    String[] donors;
    String[] bloodgroups;
    int[] stock;

    BloodBank(String[] donors, String[] bloodgroups, int[] stock) {
        this.donors = donors;
        this.bloodgroups = bloodgroups;
        this.stock = stock;
    }

    // Method to show all donors using StringBuffer
    void showDonors() {
        StringBuffer sb = new StringBuffer("DONOR LIST   :");
        for (int i = 0; i < donors.length; i++) {
            sb.append("Donor: ").append(donors[i])
              .append("  Blood Group: ").append(bloodgroups[i])
              .append("  Units: ").append(stock[i])
              .append("\n");
        }
        System.out.println(sb);
    }

    
    void findMatch(String BloodGroup) {
        int count = 0;
        StringBuffer sb = new StringBuffer("MATCHING  :");
          for (int i = 0; i < donors.length; i++) {
            if (bloodgroups[i].equals(BloodGroup)) {
                sb.append("Donor: ").append(donors[i])
                  .append(" Blood Group: ").append(bloodgroups[i])
                  .append(" Units: ").append(stock[i])
                
                  .append(stock[i] > 0 ? "Available" : "Not Available")  // ternary op
                  .append("\n");
                count = count +1;
            }
        }
        if (count == 0) {
            sb.append("No donor found for ").append(BloodGroup).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] donors = {"YAMINI", "ADITI", "VAMYA", "SANTHI", "SUKRITI", "PRAGYA", "PRANATHI", "LUCKY"};
        String[] bloodgroups = {"O+","O-","A+","A-","AB+","AB-","B+","B-"};
        int[] stock = {2,1,3,0,4,2,1,0};

        
        BloodBank bank = new BloodBank(donors, bloodgroups, stock);

        System.out.println("BLOOD BANK MENU ");
        System.out.println("1. Show donors");
        System.out.println("2. Find a match");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) {
            case 1:
                bank.showDonors();
                break;

            case 2:
                System.out.print("Enter blood group: ");
                String BloodGroup = sc.nextLine();
                bank.findMatch(BloodGroup);
                break;

            case 3:
                System.out.println("Exit");
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}

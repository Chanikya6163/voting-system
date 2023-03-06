import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import votingproject.PoliticalParty;
import votingproject.nota.NOTA;
import votingproject.party1.Party1;
import votingproject.party2.Party2;
import votingproject.party3.Party3;
import votingproject.party4.Party4;

public class VotingSystem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PoliticalParty[] parties = new PoliticalParty[5]; // Array to store parties (index 0 is for
                                                          // NOTA)
        parties[0] = new NOTA();
        parties[1] = new Party1();
        parties[2] = new Party2();
        parties[3] = new Party3();
        parties[4] = new Party4();

        int[] votes = new int[5]; // Array to store votes for each party (index 0 is for NOTA)
        // Continuously prompt the user to cast their vote until they enter "done"
        while (true) {
            System.out.println(
                    "Enter the number of the party you want to vote for (1-4) or 0 for NOTA or 'done' to finish voting: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break; // Break out of the loop if the user is done voting

            }

            if (input.equalsIgnoreCase("0")) {
                votes[0]++; // Increment the vote count for NOTA

                continue; // Go back to the start of the loop

            }

            int vote;
            try {
                vote = Integer.parseInt(input); // Try

            } catch (NumberFormatException e) {
                System.out.println("Invalid input 5c1 Please enter a valid number between 0 and 4 or 'done'.");
                continue; // Go back to the start of the loop if the input is not a valid
                          // number
            }

            if (vote < 0 || vote > 4) {
                System.out.println("Invalid input. Please enter a valid number between 0 and 4 or 'done'.");
                continue; // Go back to the start of the loop if the input is not a valid number //

            }

            votes[vote]++; // Increment the vote count for the selected party

        }

        // Get the current date and time

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY @ HH:mm:ss ");
        String dateTime = dateFormat.format(calendar.getTime());

        // Calculate the total number of votes

        double totalVotes = 0;
        for (int i = 0; i < votes.length; i++) {
            totalVotes += votes[i];
        }

        // Print the results and write them to a file

        try {
            // Create a FileWriter and a BufferedWriter to write to the file// written by
            // 5c1

            FileWriter fileWriter = new FileWriter("voting_results.txt", true); // Set the second parameter to true to//

            // append to the file

            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Write the date, time, and results to the file

            writer.write("Date: " + dateTime);
            writer.newLine(); // Write a new line

            writer.write("Total votes: " + totalVotes);
            writer.newLine(); // Write a new line

            for (int i = 0; i < parties.length; i++) {
                writer.write(parties[i].name + ": " + votes[i] + " vote(s) (" + (votes[i] / totalVotes) * 100 + "%)");

                writer.newLine(); // Write a new line

            }
            writer.newLine(); // Write an extra new line to separate results from different voting sessions//

            // Close the writers

            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }

        // Print the results to the console

        System.out.println("Date: " + dateTime);
        System.out.println("Total votes: " + totalVotes);
        for (int i = 0; i < parties.length; i++) {
            System.out.println(
                    parties[i].name + ": " + votes[i] + " vote(s) (" + (votes[i] / totalVotes) * 100 + "%)");
        }
    }
}

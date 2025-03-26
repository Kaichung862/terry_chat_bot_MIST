package terry_chatbot_;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClubLoader loader = new ClubLoader();
        ArrayList<Club> clubs = loader.loadAllClubs();

        System.out.println("👋 Welcome to the TerryChatBot!");
        System.out.println("Would you like to:\n 1) Browse and select a club\n 2) Ask anything");
        System.out.print("Enter 1 or 2: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            for (int i = 0; i < clubs.size(); i++) {
                System.out.println((i + 1) + ") " + clubs.get(i).name);
            }

            System.out.print("\nEnter the number of the club: ");
            int clubChoice = scanner.nextInt();
            scanner.nextLine();

            if (clubChoice < 1 || clubChoice > clubs.size()) {
                System.out.println("❌ Invalid choice.");
                return;
            }

            Club selectedClub = clubs.get(clubChoice - 1);
            selectedClub.displayProfile();

            System.out.print("\n💬 Ask your question: ");
            String question = scanner.nextLine();
            System.out.println("\n🤖 ChatBot Response:");
            selectedClub.respondOpenEnded(question);

        } else if (choice == 2) {
            askAnythingMode(clubs, scanner);
        } else {
            System.out.println("❌ Invalid option. Please restart.");
        }
    }

    public static void askAnythingMode(ArrayList<Club> clubs, Scanner scanner) {
        System.out.println("\n🧠 Ask me anything about any club!");
        System.out.print("Your question: ");
        String question = scanner.nextLine();

        Club matchedClub = findBestMatchingClub(question, clubs);

        if (matchedClub != null) {
            System.out.println("\n📌 Club Identified: " + matchedClub.name);
            matchedClub.respondOpenEnded(question);
        } else {
            System.out.println("❌ Sorry, I couldn't identify the club you're asking about.");
        }
    }

    
    public static Club findBestMatchingClub(String question, ArrayList<Club> clubs) {
        int bestScore = 0;
        Club bestMatch = null;
        String normalizedQuestion = question.toLowerCase();

        for (Club club : clubs) {
            int score = 0;
            for (String keyword : club.keywords) {
                if (normalizedQuestion.contains(keyword)) {
                    score++;
                }
            }

            if (normalizedQuestion.contains(club.name.toLowerCase())) {
                score += 2; // Full name match bonus
            }

            if (score > bestScore) {
                bestScore = score;
                bestMatch = club;
            }
        }

        return bestMatch;
    }
}

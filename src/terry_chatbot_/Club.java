package terry_chatbot_;

import java.util.*;

public class Club {
    public String name;
    public String meetingTime;
    public String careerPath;
    public String membershipProcess;
    public String majorRequirement;
    public boolean mistersCredit;
    public String contactInfo;

    public List<String> keywords = new ArrayList<>();

    public Club(String name, String meetingTime, String careerPath, String membershipProcess,
                String majorRequirement, boolean mistersCredit, String contactInfo) {
        this.name = name;
        this.meetingTime = meetingTime;
        this.careerPath = careerPath;
        this.membershipProcess = membershipProcess;
        this.majorRequirement = majorRequirement;
        this.mistersCredit = mistersCredit;
        this.contactInfo = contactInfo;

        // Keywords for flexible matching
        keywords.add(name.toLowerCase());
        if (name.contains("Finance")) keywords.add("finance");
        if (name.contains("Technology")) keywords.add("technology");
        if (name.contains("Consulting")) keywords.add("consulting");
        if (name.contains("Marketing")) keywords.add("marketing");
        if (name.contains("Women")) keywords.add("women");
        if (name.contains("Entrepreneurs")) keywords.add("entrepreneur");
        if (name.contains("FinTech")) keywords.add("fintech");
    }

    // Normalize string for loose comparison
    private String normalize(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9 ]", "").trim();
    }

    public boolean matchesQuestion(String question) {
        String cleanedQuestion = normalize(question);
        for (String keyword : keywords) {
            if (cleanedQuestion.contains(keyword)) {
                return true;
            }
        }
        return cleanedQuestion.contains(normalize(name));
    }

    public void respondOpenEnded(String question) {
        Map<String, String> keywordMap = new HashMap<>();
        keywordMap.put("meeting", "meetingTime");
        keywordMap.put("meet", "meetingTime");
        keywordMap.put("time", "meetingTime");
        keywordMap.put("when", "meetingTime");
        keywordMap.put("when do you meet", "meetingTime");
        keywordMap.put("where do you meet", "meetingTime");
        keywordMap.put("career", "careerPath");
        keywordMap.put("job", "careerPath");
        keywordMap.put("join", "membershipProcess");
        keywordMap.put("sign up", "membershipProcess");
        keywordMap.put("major", "majorRequirement");
        keywordMap.put("misters", "mistersCredit");
        keywordMap.put("contact", "contactInfo");

        question = question.toLowerCase();

        for (Map.Entry<String, String> entry : keywordMap.entrySet()) {
            if (question.contains(entry.getKey())) {
                switch (entry.getValue()) {
                    case "meetingTime":
                        System.out.println("🕒 Meeting Time: " + meetingTime);
                        return;
                    case "careerPath":
                        System.out.println("💼 Career Path: " + careerPath);
                        return;
                    case "membershipProcess":
                        System.out.println("👥 Membership Process: " + membershipProcess);
                        return;
                    case "majorRequirement":
                        System.out.println("📚 Major Requirement: " + majorRequirement);
                        return;
                    case "mistersCredit":
                        String credit = mistersCredit ? "Yes (or Sometimes)" : "No";
                        System.out.println("✅ MISTERS Credit: " + credit);
                        return;
                    case "contactInfo":
                        System.out.println("📧 Contact Info: " + contactInfo);
                        return;
                }
            }
        }

        System.out.println("❓ Sorry, I couldn't understand your question.");
    }

    public void displayProfile() {
        System.out.println("--------------------------------------------------");
        System.out.println("📌 Club Name: " + name);
        System.out.println("🕒 Meeting Time: " + (meetingTime.isEmpty() ? "Varies" : meetingTime));
        System.out.println("💼 Career Path: " + (careerPath.isEmpty() ? "General/Any" : careerPath));
        System.out.println("👥 Membership Process: " + (membershipProcess.isEmpty() ? "Not specified" : membershipProcess));
        System.out.println("📚 Major Requirement: " + (majorRequirement.isEmpty() ? "None" : majorRequirement));
        System.out.println("✅ MISTERS Credit: " + (mistersCredit ? "Yes (or Sometimes)" : "No"));
        System.out.println("📧 Contact Info: " + (contactInfo.isEmpty() ? "Not available" : contactInfo));
        System.out.println("--------------------------------------------------");
    }
}

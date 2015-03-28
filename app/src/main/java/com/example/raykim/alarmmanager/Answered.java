package com.example.raykim.alarmmanager;

/**
 * Created by ha on 28/03/15.
 */
public class Answered {

    private Boolean answers = false;

        private static Answered instance = null;
        protected Answered() {
            // Exists only to defeat instantiation.
        }
        public static Answered getInstance() {
            if(instance == null) {
                instance = new Answered();
            }
            return instance;
        }

    public Boolean getAnswers() {
        return answers;
    }

    public void setAnswers(Boolean answers) {
        this.answers = answers;
    }
}

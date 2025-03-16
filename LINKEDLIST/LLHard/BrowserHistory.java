package LINKEDLIST.LLHard;

public class BrowserHistory {
    static class Node{
        String data;
        Node next;
        Node back;

        public Node(String data) {
            this.data = data;
            this.back = null;
            this.next = null;
        }
    }

    public static Node currentPage;
    public BrowserHistory(String homepage){
        currentPage = new Node(homepage);
    }

    public void visit(String url){
        Node newNode = new Node(url);
        currentPage.next=newNode;
        newNode.back=currentPage;
        currentPage=newNode;
    }

    public String back(int steps){
        while(steps > 0){
            if(currentPage.back!=null){
                currentPage=currentPage.back;
            }else{
                break;
            }
            steps--;
        }
        return currentPage.data;
    }

    public static String forward(int steps){
        while(steps > 0){
            if(currentPage.next!=null){
                currentPage = currentPage.next;
            }else{
                break;
            }
            steps--;
        }
        return currentPage.data;
    }

    public String getCurrentPage() {
        return currentPage.data;
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("homepage.com");

        browser.visit("page1.com");
        browser.visit("page2.com");
        browser.visit("page3.com");

        System.out.println(browser.back(1));  // Outputs: page2.com
        System.out.println(browser.back(1));  // Outputs: page1.com
        System.out.println(BrowserHistory.forward(1));  // Outputs: page2.com

        browser.visit("page4.com");
        System.out.println(browser.back(2));  // Outputs: page1.com
    }
}

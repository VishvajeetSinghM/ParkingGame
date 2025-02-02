/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class ParkSort extends HttpServlet {

    public static ArrayList<String> LaneA = new ArrayList<>();
    public static ArrayList<String> LaneB = new ArrayList<>();
    public static ArrayList<String> LaneC = new ArrayList<>();
    public static ArrayList<String> LaneD = new ArrayList<>();
    public static ArrayList<String> LaneE = new ArrayList<>();
    
    static{
        Random random = new Random();
        
        
        List<String> shuffledList = new ArrayList<>(); 
        for (int i = 0; i < 4; i++) {
            shuffledList.add("A");
            shuffledList.add("B");
            shuffledList.add("C");
            
        }
        Collections.shuffle(shuffledList, random);
        LaneA.addAll(shuffledList.subList(0, 4));
        LaneB.addAll(shuffledList.subList(4, 8));
        LaneC.addAll(shuffledList.subList(8, 12));
    }
    
     public static void hato(ArrayList<String> list,ArrayList<String> list2) {
        
        String lastElt = null;
        if (!list.isEmpty()) {
            lastElt = list.get(list.size() - 1); 
        }

        
        for (int i = list.size() - 1; i >= 0; i--) {
            String currentValue = list.get(i);

            
            if (!currentValue.equals(lastElt)) {
                break; 
            }

        
            list2.add(list.remove(i)); // Remove the element from the ArrayList
        }
    }
    
    public static boolean arraysize() {
        int sortedLaneCount = 0;
    
        if (LaneA.size() == 4 && isSingleType(LaneA)) sortedLaneCount++;
        if (LaneB.size() == 4 && isSingleType(LaneB)) sortedLaneCount++;
        if (LaneC.size() == 4 && isSingleType(LaneC)) sortedLaneCount++;
        if (LaneD.size() == 4 && isSingleType(LaneD)) sortedLaneCount++;
        if (LaneE.size() == 4 && isSingleType(LaneE)) sortedLaneCount++;
    
        return sortedLaneCount == 3;
    }

    
    private static boolean isSingleType(ArrayList<String> lane) {
        if (lane.isEmpty()) return false;

        String firstElement = lane.get(0); 

        
        for (String car : lane) {
            if (!car.equals(firstElement)) {
                return false; 
            }
        }
        return true;
    }

    public static void printLanes(){
        System.out.println("LANE 1 : " + String.join(" | ", LaneA) + " >");
    System.out.println("LANE 2 : " + String.join(" | ", LaneB) + " >");
    System.out.println("LANE 3 : " + String.join(" | ", LaneC) + " >");
    System.out.println("LANE 4 : " + String.join(" | ", LaneD) + " >");
    System.out.println("LANE 5 : " + String.join(" | ", LaneE) + " >");
    System.out.println();
//        System.out.print("LANE 1 : " );
//        for (String value : LaneA) {
//            System.out.print(" | "+value);
//        }
//        System.err.print(" > ");
//        System.err.println();
//        System.out.print("LANE 2 : ");
//        for (String value : LaneB) {
//            System.out.print(" | "+value);
//        }
//        System.err.print(" > ");
//        System.err.println();
//        System.out.print("LANE 3 : ");
//        for (String value : LaneC) {
//            System.out.print(" | "+value);
//        }
//        System.err.print(" > ");
//        System.err.println();
//        System.out.print("LANE 4 : ");
//        for (String value : LaneD) {
//            System.out.print(" | "+value);
//        }
//        System.err.print(" > ");
//        System.err.println();
//        System.out.print("LANE 5 : ");
//        for (String value : LaneE) {
//            System.out.print(" | "+value);
//        }
//        System.err.print(" > ");
//        System.err.println();
//        System.err.println();
    }
    
//    private ArrayList<String> getLaneByName(String laneName) {
//    switch (laneName) {
//        case "LaneA":
//            return LaneA;
//        case "LaneB":
//            return LaneB;
//        case "LaneC":
//            return LaneC;
//        case "LaneD":
//            return LaneD;
//        case "LaneE":
//            return LaneE;
//        default:
//            return null;
//    }
//}


    public static void userInput(int laneNumber1, int laneNumber2) {
        
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.print("Enter the first lane number (1, 2, 3, 4, 5): ");
//        int laneNumber1 = scanner.nextInt(); 
//    
//        System.out.print("Enter the second lane number (1, 2, 3, 4, 5): ");
//        int laneNumber2 = scanner.nextInt(); 
       
        ArrayList<String> selectedLane1 = null;
        ArrayList<String> selectedLane2 = null;
    
        switch (laneNumber1) {
            case 1:
                selectedLane1 = LaneA;
                break;
            case 2:
                selectedLane1 = LaneB;
                break;
            case 3:
                selectedLane1 = LaneC;
                break;
            case 4:
                selectedLane1 = LaneD;
                break;
            case 5:
                selectedLane1 = LaneE;
                break;
            default:
                System.out.println("Invalid first lane number.");
                break;
        }
    
        switch (laneNumber2) {
            case 1:
                selectedLane2 = LaneA;
                break;
            case 2:
                selectedLane2 = LaneB;
                break;
            case 3:
                selectedLane2 = LaneC;
                break;
            case 4:
                selectedLane2 = LaneD;
                break;
            case 5:
                selectedLane2 = LaneE;
                break;
            default:
                System.out.println("Invalid second lane number.");
                break;
        }
    
        // If both lanes are valid, call the function
        if (selectedLane1 != null && selectedLane2 != null) {
            hato(selectedLane1, selectedLane2);
        }
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                HttpSession session = request.getSession();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            String[] selectedLanes = request.getParameterValues("lane");
            String selectedOrder = request.getParameter("selectedOrder");
            if(selectedOrder!=null ){
                   System.out.println(selectedOrder);
                   String sel[] = selectedOrder.split(",");
                userInput(Integer.parseInt(sel[0]),Integer.parseInt(sel[1]));

            }
                        System.out.println("*******");
//            if(request.getParameterValues("lane")!=null){
//                userInput(Integer.parseInt(selectedLanes[0]),Integer.parseInt(selectedLanes[1]));
//                System.out.println("to: "+selectedLanes[0]);
//                System.out.println("from: "+selectedLanes[1]);
//            }
//            
        session.setAttribute("laneA", LaneA);
        session.setAttribute("laneB", LaneB);
        session.setAttribute("laneC", LaneC);
        session.setAttribute("laneD", LaneD);
        session.setAttribute("laneE", LaneE);
        if(arraysize()){
            session.setAttribute("greet", "Congrats Cars are sorted");
        }



                
        
        printLanes();
        request.getRequestDispatcher("GameView.jsp").forward(request, response);
            


            out.println("<head>");
            out.println("<title>Servlet ParkSort</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParkSort at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold
}

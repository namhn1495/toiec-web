/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nam.loda.vn.toiec.web.controller;

import com.nam.loda.vn.toiec.web.model.Helper;
import com.nam.loda.vn.toiec.web.model.Word;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author loda
 */
public class NextCardServlet2 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Path: " + System.getProperty("java.class.path"));
        if (!Helper.isInit) {
            try {
                Helper.init();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NextCardServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NextCardServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!request.getParameter("id").equals("0")) {
            Helper.setAnswer(Integer.valueOf(request.getParameter("level")));
        }

        response.getWriter().println(response(Helper.nextWord()));
        response.getWriter().close();
    }

    public String response(Word w) {
        String s = " <div class=\"flipper\">\n"
                + "            <div class=\"front\">\n"
                + "                <div class=\"card text-center align-middle\" style=\"width: 100%; height: 100%; \">\n"
                + "                    <div class=\"back-container text-center align-middle\">\n"
                + "<p id = \"idw\">" + w.getId() + "</p>"
                + "                        <p>\n"
                + "                            <b>"
                + w.getRawText()
                + "                            </b>\n"
                + "                        </p>\n"
                + "                        <p>"
                + w.getPhonetic()
                + "                        </p>\n"
                + "                        <audio controls id='audio'>\n"
                + "                            <!-- <source src=\"horse.ogg\" type=\"audio/ogg\"> -->\n"
                + "                            <source src=\"" + w.getAudioUrl() + "\" type=\"audio/mpeg\"> Your browser does not support the audio tag.\n"
                + "                        </audio>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "            <div class=\"back\">\n"
                + "                <div class=\"card text-center align-middle\" style=\"width: 100%; height: 100%; \">\n"
                + "                    <div class=\"front-container text-center align-middle\">\n"
                + "                        <h5>\n"
                + w.getMeaningInVietNam()
                + "                        </h5>\n"
                + "                        <p>"
                + w.getPhonetic()
                + "                        </p>\n"
                + "                        <p>" + w.getExampleEng() + " <a href='#' onclick='tts(\""+w.getExampleEng()+"\")'>voice</a></p>\n"
                + "                        <p>" + w.getExampleVi() + "</p>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "\n"
                + "            </div>\n"
                + "        </div>";
        return s;
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
    }// </editor-fold>

}

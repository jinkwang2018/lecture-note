<%@page import="net.sf.json.JSONArray"%>
<%@page import="kr.or.bmark.dto.mainBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%=(JSONArray)request.getAttribute("jsonlist") %>


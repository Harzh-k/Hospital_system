package com.dao;

import com.entity.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {

    private Connection conn;

    public AppointmentDao(Connection conn){
        super();
        this.conn=conn;
    }

    public boolean addAppointment(Appointment ap){
        boolean f= false;
        try{
            String sql="insert into appointment(user_id,fullname,gender,age,appointment_date,email,phone_no,disease,doctor_id,address,status) values (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,ap.getUserId());
            ps.setString(2,ap.getFullName());
            ps.setString(3,ap.getGender());
            ps.setString(4,ap.getAge());
            ps.setString(5,ap.getAppointmentDate());
            ps.setString(6,ap.getEmail());
            ps.setString(7,ap.getPhoneNo());
            ps.setString(8,ap.getDisease());
            ps.setInt(9,ap.getDoctorId());
            ps.setString(10,ap.getAddress());
            ps.setString(11,ap.getStatus());

            int i=ps.executeUpdate();

            if(i==1){
                f=true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public List<Appointment> getAllAppointmentByLoginUser(int userId){
        List<Appointment> list=new ArrayList<>();
        Appointment ap=null;

        try{

            String sql="select * from appointment where user_id=?";

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,userId);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ap=new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullName(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppointmentDate(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setPhoneNo(rs.getString(8));
                ap.setDisease(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                ap.setAddress(rs.getString(11));
                ap.setStatus(rs.getString(12));
                list.add(ap);
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public List<Appointment> getAllAppointmentByDoctorId(int doctorId){
        List<Appointment> list=new ArrayList<>();
        Appointment ap=null;

        try{

            String sql="select * from appointment where doctor_id=?";

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,doctorId);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ap=new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullName(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppointmentDate(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setPhoneNo(rs.getString(8));
                ap.setDisease(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                ap.setAddress(rs.getString(11));
                ap.setStatus(rs.getString(12));
                list.add(ap);
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public Appointment  getAllAppointmentById(int id){
        Appointment ap=null;
        try{

            String sql="select * from appointment where id=?";

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ap=new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullName(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppointmentDate(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setPhoneNo(rs.getString(8));
                ap.setDisease(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                ap.setAddress(rs.getString(11));
                ap.setStatus(rs.getString(12));

            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return ap;
    }

    public boolean updateCommentStatus(int id,int doctId ,String comm){
        boolean f =false;
        try{
            String sql="update appointment set status=? where id=? and doctor_id=?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,comm);
            ps.setInt(2,id);
            ps.setInt(3,doctId);

            int i=ps.executeUpdate();
            if(i==1){
                f=true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public List<Appointment> getAllAppointment(){
        List<Appointment> list=new ArrayList<>();
        Appointment ap=null;

        try{

            String sql="select * from appointment order by id desc";

            PreparedStatement ps=conn.prepareStatement(sql);


            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ap=new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullName(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppointmentDate(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setPhoneNo(rs.getString(8));
                ap.setDisease(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                ap.setAddress(rs.getString(11));
                ap.setStatus(rs.getString(12));
                list.add(ap);
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

}

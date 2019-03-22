package kr.or.kosta.DTO;


public class empDTO {
   private int empno;
   private String ename;
   private String job;
   private int mgr;
   private String hiredate;
   private int sal;
   private int comm;
   private int deptno;
   private String dname;
   
   public empDTO () {} ;
   
   public empDTO(int empno, String ename, String job, int mgr,
		   String hiredate, int sal, int comm, int deptno) {
      
      this.empno = empno;
      this.ename = ename;
      this.job = job;
      this.mgr = mgr;
      this.hiredate = hiredate;
      this.sal = sal;
      this.comm = comm;
      this.deptno = deptno;
   }
   public int getEmpno() {
      return empno;
   }
   public void setEmpno(int empno) {
      this.empno = empno;
   }
   public String getEname() {
      return ename;
   }
   public void setEname(String ename) {
      this.ename = ename;
   }
   public String getJob() {
      return job;
   }
   public void setJob(String job) {
      this.job = job;
   }
   public int getMgr() {
      return mgr;
   }
   public void setMgr(int mgr) {
      this.mgr = mgr;
   }
   public String getHiredate() {
      return hiredate;
   }
   public void setHiredate(String hiredate) {
      this.hiredate = hiredate;
   }
   public int getSal() {
      return sal;
   }
   public void setSal(int sal) {
      this.sal = sal;
   }
   public int getComm() {
      return comm;
   }
   public void setComm(int comm) {
      this.comm = comm;
   }
   public int getDeptno() {
      return deptno;
   }
   public void setDeptno(int deptno) {
      this.deptno = deptno;
   }

public String getDname() {
	return dname;
}

public void setDname(String dname) {
	this.dname = dname;
}

@Override
public String toString() {
	return "empDTO [empno=" + empno + ", ename=" + ename + ", job=" + job
			+ ", mgr=" + mgr + ", hiredate=" + hiredate + ", sal=" + sal
			+ ", comm=" + comm + ", deptno=" + deptno + ", dname=" + dname
			+ "]";
}
   

 
}
package com.baobab.m.vo;

import java.util.Date;

public class DailyReportVO {
	private int seqNum;
	private String id;
	private String name;
	private String department;
	private String jobClass;
	private String attendTime;
	private String closeTime;
	private String todayJob;
	private String tomorrowJob;
	private String successJob;
	private String unSuccessJob;
	private Date reportDate;
	private Date updateDate;
	public DailyReportVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DailyReportVO(int seqNum, String id, String name, String department, String jobClass, String attendTime,
			String closeTime, String todayJob, String tomorrowJob, String successJob, String unSuccessJob,
			Date reportDate, Date updateDate) {
		super();
		this.seqNum = seqNum;
		this.id = id;
		this.name = name;
		this.department = department;
		this.jobClass = jobClass;
		this.attendTime = attendTime;
		this.closeTime = closeTime;
		this.todayJob = todayJob;
		this.tomorrowJob = tomorrowJob;
		this.successJob = successJob;
		this.unSuccessJob = unSuccessJob;
		this.reportDate = reportDate;
		this.updateDate = updateDate;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJobClass() {
		return jobClass;
	}
	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}
	public String getAttendTime() {
		return attendTime;
	}
	public void setAttendTime(String attendTime) {
		this.attendTime = attendTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getTodayJob() {
		return todayJob;
	}
	public void setTodayJob(String todayJob) {
		this.todayJob = todayJob;
	}
	public String getTomorrowJob() {
		return tomorrowJob;
	}
	public void setTomorrowJob(String tomorrowJob) {
		this.tomorrowJob = tomorrowJob;
	}
	public String getSuccessJob() {
		return successJob;
	}
	public void setSuccessJob(String successJob) {
		this.successJob = successJob;
	}
	public String getUnSuccessJob() {
		return unSuccessJob;
	}
	public void setUnSuccessJob(String unSuccessJob) {
		this.unSuccessJob = unSuccessJob;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendTime == null) ? 0 : attendTime.hashCode());
		result = prime * result + ((closeTime == null) ? 0 : closeTime.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jobClass == null) ? 0 : jobClass.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reportDate == null) ? 0 : reportDate.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((successJob == null) ? 0 : successJob.hashCode());
		result = prime * result + ((todayJob == null) ? 0 : todayJob.hashCode());
		result = prime * result + ((tomorrowJob == null) ? 0 : tomorrowJob.hashCode());
		result = prime * result + ((unSuccessJob == null) ? 0 : unSuccessJob.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DailyReportVO other = (DailyReportVO) obj;
		if (attendTime == null) {
			if (other.attendTime != null)
				return false;
		} else if (!attendTime.equals(other.attendTime))
			return false;
		if (closeTime == null) {
			if (other.closeTime != null)
				return false;
		} else if (!closeTime.equals(other.closeTime))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jobClass == null) {
			if (other.jobClass != null)
				return false;
		} else if (!jobClass.equals(other.jobClass))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reportDate == null) {
			if (other.reportDate != null)
				return false;
		} else if (!reportDate.equals(other.reportDate))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (successJob == null) {
			if (other.successJob != null)
				return false;
		} else if (!successJob.equals(other.successJob))
			return false;
		if (todayJob == null) {
			if (other.todayJob != null)
				return false;
		} else if (!todayJob.equals(other.todayJob))
			return false;
		if (tomorrowJob == null) {
			if (other.tomorrowJob != null)
				return false;
		} else if (!tomorrowJob.equals(other.tomorrowJob))
			return false;
		if (unSuccessJob == null) {
			if (other.unSuccessJob != null)
				return false;
		} else if (!unSuccessJob.equals(other.unSuccessJob))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DailyReportVO [seqNum=" + seqNum + ", id=" + id + ", name=" + name + ", department=" + department
				+ ", jobClass=" + jobClass + ", attendTime=" + attendTime + ", closeTime=" + closeTime + ", todayJob="
				+ todayJob + ", tomorrowJob=" + tomorrowJob + ", successJob=" + successJob + ", unSuccessJob="
				+ unSuccessJob + ", reportDate=" + reportDate + ", updateDate=" + updateDate + "]";
	}
}

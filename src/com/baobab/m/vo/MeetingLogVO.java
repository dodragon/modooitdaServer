package com.baobab.m.vo;

import java.util.Date;

public class MeetingLogVO {
	private int seqNum;
	private String meetingTitle;
	private String mainAgenda;
	private String meetingContents;
	private String meetingResult;
	private String writer;
	private String director;
	private String place;
	private int nop;
	private String attendees;
	private Date startTime;
	private Date endTime;
	private Date meetingDate;
	
	public MeetingLogVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MeetingLogVO(int seqNum, String meetingTitle, String mainAgenda, String meetingContents,
			String meetingResult, String writer, String director, String place, int nop, String attendees,
			Date startTime, Date endTime, Date meetingDate) {
		super();
		this.seqNum = seqNum;
		this.meetingTitle = meetingTitle;
		this.mainAgenda = mainAgenda;
		this.meetingContents = meetingContents;
		this.meetingResult = meetingResult;
		this.writer = writer;
		this.director = director;
		this.place = place;
		this.nop = nop;
		this.attendees = attendees;
		this.startTime = startTime;
		this.endTime = endTime;
		this.meetingDate = meetingDate;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getMeetingTitle() {
		return meetingTitle;
	}
	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}
	public String getMainAgenda() {
		return mainAgenda;
	}
	public void setMainAgenda(String mainAgenda) {
		this.mainAgenda = mainAgenda;
	}
	public String getMeetingContents() {
		return meetingContents;
	}
	public void setMeetingContents(String meetingContents) {
		this.meetingContents = meetingContents;
	}
	public String getMeetingResult() {
		return meetingResult;
	}
	public void setMeetingResult(String meetingResult) {
		this.meetingResult = meetingResult;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getNop() {
		return nop;
	}
	public void setNop(int nop) {
		this.nop = nop;
	}
	public String getAttendees() {
		return attendees;
	}
	public void setAttendees(String attendees) {
		this.attendees = attendees;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendees == null) ? 0 : attendees.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((mainAgenda == null) ? 0 : mainAgenda.hashCode());
		result = prime * result + ((meetingContents == null) ? 0 : meetingContents.hashCode());
		result = prime * result + ((meetingDate == null) ? 0 : meetingDate.hashCode());
		result = prime * result + ((meetingResult == null) ? 0 : meetingResult.hashCode());
		result = prime * result + ((meetingTitle == null) ? 0 : meetingTitle.hashCode());
		result = prime * result + nop;
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
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
		MeetingLogVO other = (MeetingLogVO) obj;
		if (attendees == null) {
			if (other.attendees != null)
				return false;
		} else if (!attendees.equals(other.attendees))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (mainAgenda == null) {
			if (other.mainAgenda != null)
				return false;
		} else if (!mainAgenda.equals(other.mainAgenda))
			return false;
		if (meetingContents == null) {
			if (other.meetingContents != null)
				return false;
		} else if (!meetingContents.equals(other.meetingContents))
			return false;
		if (meetingDate == null) {
			if (other.meetingDate != null)
				return false;
		} else if (!meetingDate.equals(other.meetingDate))
			return false;
		if (meetingResult == null) {
			if (other.meetingResult != null)
				return false;
		} else if (!meetingResult.equals(other.meetingResult))
			return false;
		if (meetingTitle == null) {
			if (other.meetingTitle != null)
				return false;
		} else if (!meetingTitle.equals(other.meetingTitle))
			return false;
		if (nop != other.nop)
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MeetingLogVO [seqNum=" + seqNum + ", meetingTitle=" + meetingTitle + ", mainAgenda=" + mainAgenda
				+ ", meetingContents=" + meetingContents + ", meetingResult=" + meetingResult + ", writer=" + writer
				+ ", director=" + director + ", place=" + place + ", nop=" + nop + ", attendees=" + attendees
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", meetingDate=" + meetingDate + "]";
	}
}

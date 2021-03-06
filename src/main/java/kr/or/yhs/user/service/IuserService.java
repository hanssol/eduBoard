package kr.or.yhs.user.service;

import java.util.List;
import java.util.Map;

import kr.or.yhs.paging.model.PageVo;
import kr.or.yhs.user.model.UserVo;

public interface IuserService {
	
	/**
	 * 
	 * Method : userList
	 * 작성자 : PC03
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	List<UserVo> userList();
	
	UserVo getUser(String userId);

	Map<String, Object> userPagingList(PageVo pageVo);
	
	int insertUser(UserVo userVo);

	int deleteUser(String userId);
	
	int modifyUser(UserVo userVo);
	
	/**
	 * 
	 * Method : encryptPassAllUser
	 * 작성자 : PC03
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	 */
	int encryptPassAllUser();
}

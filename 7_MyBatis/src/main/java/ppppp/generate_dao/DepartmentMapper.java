package ppppp.generate_dao;

import java.util.List;
import ppppp.generate_bean.Department;

public interface DepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbg.generated Tue Jan 26 09:47:09 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbg.generated Tue Jan 26 09:47:09 CST 2021
     */
    int insert(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbg.generated Tue Jan 26 09:47:09 CST 2021
     */
    Department selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbg.generated Tue Jan 26 09:47:09 CST 2021
     */
    List<Department> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbg.generated Tue Jan 26 09:47:09 CST 2021
     */
    int updateByPrimaryKey(Department record);
}
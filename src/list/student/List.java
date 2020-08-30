package list.student;

import java.util.LinkedList;

/**
 * @author Ji Rui
 * @date 2020/8/23 20:21
 */
public interface List {

    /**
     * 插入
     * @param student 待插入的学生成绩信息
     * @return 插入成功则返回当前数组大小
     */
    int insert(Student student);

    /**
     * 删除（根据id）
     * @param id 待删除的学生的id
     * @return 删除成功则返回true，失败则返回false
     */
    boolean delete(String id);

    /**
     * 获取前驱
     * @param id 获取学号id的前驱
     * @return 返回前驱
     */
    Student getPre(String id);

    /**
     * 统计分数在[low, high]区间内的人数
     * @param low 区间左边界
     * @param high 区间右边界
     * @return 返回人数
     */
    int getStatistics(int low, int high);

    /**
     * 遍历
     * @return 返回一个包含所有信息的LinkedList
     */
    LinkedList<Student> traverse();
}

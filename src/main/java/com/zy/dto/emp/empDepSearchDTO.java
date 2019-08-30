package com.zy.dto.emp;

import com.zy.bean.Employee;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * @Auther: zy
 * @Date: 2019/8/12 23:49
 * @Description:
 */
public class empDepSearchDTO extends Employee implements Serializable {

        private String depname;

        private String depleader;

        private String hiredateStr;

        public String getDepname() {
                return depname;
        }

        public void setDepname(String depname) {
                this.depname = depname;
        }

        public String getDepleader() {
                return depleader;
        }

        public void setDepleader(String depleader) {
                this.depleader = depleader;
        }

        public String getHiredateStr() {
                return hiredateStr;
        }

        public void setHiredateStr(String hiredateStr) {
                this.hiredateStr = hiredateStr;
        }

        @Override
        public String toString() {
                return "empDepSearchDTO{" +
                        "depname='" + depname + '\'' +
                        ", depleader='" + depleader + '\'' +
                        ", hiredateStr='" + hiredateStr + '\'' +
                        '}';
        }
}

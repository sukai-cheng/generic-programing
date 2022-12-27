package sukai.controller;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengsukai
 * @since 2022-10-08 10:54
 */
@Data
@Builder
public class User implements Serializable {
   Integer id;
   String name;
   Object user;
}

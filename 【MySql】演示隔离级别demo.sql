-- 查看隔离级别（当前会话）
select @@tx_isolation;    -- 或者：show variables like 'tx_isolation'

-- 设置隔离级别
set tx_isolation = 'read-uncommitted';  -- read-uncommitted    read-committed    repeatable-read    serializable

-- set autocommit = 1;   1、on代表开启; 0、off代表关闭

# 事务的隔离级别导致的问题 & 事务的隔离级别
# 注意：之所以会产生隔离级别的问题是基于事务会并发执行的前提。
  # 脏读【读取未提交的数据时发生的】——需要隔离级别读已提交才可解决
    set tx_isolation = 'read-uncommitted';   -- 该隔离级别会有的问题
    -- 事务1
    start transaction;   -- 开启一个新的事务
    update user set uname = 'lihongjie_temp' where uid = 1;  -- 此时若去执行事务2中的查询，可以读取到uname='lihongjie_temp'
    rollback;   -- rollback/commit 在mysql中可以结束开启的事务

    -- 事务2
    -- start transaction;
    select * from user;    -- 单独执行语句会有默认的事务（隐式）
    -- rollback;

  # 不可重复读【读取已经提交的数据时发生的】——需要隔离级别可重复读才可解决
    set tx_isolation = 'repeatable-read';   -- 该隔离级别会有的问题
    -- 事务1
    start transaction;
    update user set uname = 'lihongjie_temp' where uid = 1;
    commit;     -- commit之后进行事务2的第二次查询
    -- 事务2
    start transaction;
    select * from user where uid = 1;   -- 事务1提交之前进行一次查询，结果为：lihongjie
    select * from user where uid = 1;   -- 事务1提交之后进行的一次查询，结果为：lihongjie_temp
    commit;

  # 幻读【读取已经提交的数据时发生的】——需要隔离级别串行化才可解决
    set tx_isolation = 'read-committed';   -- 该隔离级别会有的问题

    -- 事务1
    start transaction;
    insert into user values (null,'temp', 1);
    commit;     -- commit之后进行事务2的第二次查询
    -- 事务2
    start transaction;
    select * from user ;   -- 事务1提交之前进行一次查询，查找不到(null,'temp', 1)这条记录
    select * from user ;   -- 事务1提交之后进行的一次查询，可以查找到
    commit;


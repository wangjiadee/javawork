##### Stream

 1. Stream关注的是对数据的运算，与CPU打交道
    集合关注的是数据的存储，与内存打交道
  2.  ①Stream 自己不会存储元素。
     ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
     ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
  3.  Stream 执行流程
     ① Stream的实例化
     ② 一系列的中间操作（过滤、映射、...)
     ③ 终止操作
  4.  说明：
     4.1 一个中间操作链，对数据源的数据进行处理
     4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用

```JAVA
    /**
     * Description: 创建Stream方式一 通过集合
     
     * return      
     * Author:     ralph
     **/
    @Test
    public void CreateStream1(){
        
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();
        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    /**
     * Description: 创建Stream方式2 通过数组来创建

     * return
     * Author:     ralph
     **/
    @Test
    public void CreateStream2(){
        int[] ints = {12, 23, 34, 45, 56, 67};

        IntStream stream = Arrays.stream(ints);

        Employee fUCK = new Employee(1001, "fUCK");
        Employee fUCK2 = new Employee(1002, "fUCK2");
        Employee[] employees = {fUCK, fUCK2};
        Stream<Employee> stream1 = Arrays.stream(employees);
    }
    /**
     * Description: 创建Stream方式3 用过Streamof创建

     * return
     * Author:     ralph
     **/
    @Test
    public void CreateStream3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println(integerStream);
    }
    /**
     * Description: 创建Stream方式4 创建无限流

     * return      
     * Author:     ralph
     **/
    @Test
    public void CreateSteam4(){
        //迭代
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);
        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }


    //Stream的中间操作
    @Test
    public void Middle(){
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();

        stream.filter(e -> e.getSalary() > 6000).forEach(System.out::println);

        System.out.println("limit(n)截断流，使其元素不超过给定数量");
        employees.stream().limit(3).forEach(System.out::println);

        System.out.println("skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补");
        employees.stream().skip(3).forEach(System.out::println);

        employees.add(new Employee(1010,"Jen",20,2222));
        employees.add(new Employee(1010,"Jen",20,2222));
        employees.add(new Employee(1010,"Jen",20,2222));
        employees.add(new Employee(1010,"Jen",20,2222));
        employees.add(new Employee(1010,"Jen",22,2222));
        System.out.println("distinct 筛选通过流所生成的元素并去重");
        employees.stream().distinct().forEach(System.out::println);

    }

    //映射
    @Test
    public void Mapping(){

//map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "Ccc", "QQQ", "ppp");
        list.stream().map(str -> str.toUpperCase(Locale.ROOT)).forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        stringStream.filter(name -> name.length() >3).forEach(System.out::println);

    }
    //排序
    @Test
    public void SortedTest(){
        //自然排序
        List<Integer> integers = Arrays.asList(12, 34, 444, 31, 6, 76, 8876, 83);
        integers.stream().sorted().forEach(System.out::println);


        //定制排序
        List<Employee> employees3 = EmployeeData.getEmployees();
        employees3.stream().sorted( (e1,e2) ->{
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if (compare != 0){
                return compare;
            }else {
                return -Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);

    }


    //测试Stream的终止操作
    @Test
    public void StreamEndTest(){
        List<Employee> employees = EmployeeData.getEmployees();
//        allMatch(Predicate p)——检查是否匹配所有元素。

       boolean  allMatch = employees.stream().allMatch(e -> e.getAge() >20);
        System.out.println(allMatch);


//        anyMatch(Predicate p)——检查是否至少匹配一个元素。
       boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);


//        noneMatch(Predicate p)——检查是否没有匹配的元素。
         boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

//        findFirst——返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

//        findAny——返回当前流中的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);


        // count——返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() <5000).count();
        System.out.println(count);


//        max(Comparator c)——返回流中最大值
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = doubleStream.max(Double::compare);
        System.out.println(max);

//        min(Comparator c)——返回流中最小值
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

        employees.forEach(System.out::println);


//        reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10, 9);
        Integer reduce = integers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);



//        reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        Stream<Double> doubleStream1 = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce1 = doubleStream1.reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce1.get());


//        collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6999).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Set<Employee> set = employees.stream().filter(e -> e.getSalary() > 6999).collect(Collectors.toSet());
        set.forEach(System.out::println);

    }

```


package com.study.springboot;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;
import net.minidev.json.annotate.JsonIgnore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.swing.text.DateFormatter;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class Tests1 {


    @Test
    public void test() {

        LocalDate localDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endMonthOfQuarterDate = LocalDate.of(localDate.getYear(), Month.of(localDate.getMonth().firstMonthOfQuarter().getValue() + 2), Month
                .of(localDate.getMonth().firstMonthOfQuarter().getValue() + 2).length(localDate.isLeapYear()));

        if (localDate.compareTo(endMonthOfQuarterDate) != 0) {
            localDate = localDate.minusMonths(3);
        }
        LocalDate resDate = null;

        List<Date> dateList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            LocalDate middleDate = localDate.minusMonths(3 * i);
            Month month = middleDate.getMonth();
            Month endMonthOfQuarter = Month.of(month.firstMonthOfQuarter().getValue() + 2);
            resDate = LocalDate.of(middleDate.getYear(), endMonthOfQuarter, endMonthOfQuarter.length(middleDate.isLeapYear()));
            dateList.add(Date.from(resDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }
        dateList.stream().forEach(date -> {
            System.out.println(date);
        });
    }

    @Test
    public void test2() {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
    }

    @Test
    public void test3() {
        BigDecimal b1 = new BigDecimal("0");
        BigDecimal b2 = null;

//        System.out.println(b1.compareTo(b2) == 0);

        System.out.println(new BigDecimal("1.1234").divide(new BigDecimal("0.2")));
    }

    @Test
    public void test4() {
        Map<String, String> map = new HashMap<>();
        map.values().stream().forEach(str -> {
            System.out.println(str);
        });
    }

    @Test
    public void test5() {
//        String express = "math.sqrt(math.sqrt(x))";

        AviatorEvaluator.getInstance().setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL, true);
        AviatorEvaluator.getInstance().setOption(Options.ALWAYS_PARSE_INTEGRAL_NUMBER_INTO_DECIMAL, true);
//        AviatorEvaluator.getInstance().setOption(Options.MATH_CONTEXT, MathContext.DECIMAL64);

        Expression expression = AviatorEvaluator.compile("x * 1.11111111111111111");
        Map<String, Object> params = new HashMap<>();
        params.put("x", new BigDecimal("10"));

        Object execute = expression.execute(params);
        System.out.println(execute instanceof Double);
        System.out.println(execute);

//        System.out.println("result: "+ result);

//        AviatorEvaluator.validate("(a+b)");

        // 注册函数
//        AviatorEvaluator.addFunction(new MaxFunction());

//        String expression = "seq.min(list) > 0 ? seq.max(list):seq.min(list)";
//        AviatorEvaluator.validate(expression);
//        Map<String, Object> params = new HashMap<>();
//        params.put("list", Arrays.asList(3, 4, 6));


//        Object execute = AviatorEvaluator.execute(expression, params);

//        if (execute instanceof Double) {
//            System.out.println(new BigDecimal((Double)execute));
//        } else if (execute instanceof BigDecimal) {
//            System.out.println(execute);
//        }

//        System.out.printf("result : " + execute);

    }

    @Test
    public void test6() {
        String regex = "\\[\\s*(资产负债表|利润表|现金流量表)\\.p[1-3][1-4]\\.(合并报表|母公司报表)\\.\\S+?\\s*\\]";
        String str = "  [  资产负债表.p11.合并报表.所有者权益(或股东权益)： ] [  现金流量表.p22.母公司报表.所有者权益(或股东权益)： ] ";

        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(str);

        List<String> matchList = new ArrayList<>();
        while (matcher.find()) {
            matchList.add(matcher.group());
        }

        for (int i = 0; i < matchList.size(); i++) {
            System.out.println(matchList.get(i));
            String s = str.replace(matchList.get(i), String.valueOf(Math.random() * 10));
            System.out.println(s);
        }
    }

    @Test
    public void test7() {
        int start = 'A';
        for (int i = 0; i < 8 / 26 + 1; i++) {
            String first = String.valueOf((char) (start + i));
            for (int j = 0; (8 - 26 * i) >= 26 ? j < 26 : j < (8 - 26 * i) % 26; j++) {
                String second = String.valueOf((char) (start + j));
                System.out.println(first + second);
            }
        }
    }

    @Test
    public void test8() {
        String str = "abc";
        System.out.println(str.charAt(1));
    }

    @Test
    public void test9() {
        List<String> list = null;
        System.out.println(CollectionUtils.isEmpty(list));
        list = new ArrayList<>();

        System.out.println(CollectionUtils.isEmpty(list));
    }

    @Test
    public void test10() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");

        arrayList.stream().anyMatch(ar -> {
            System.out.println("ar = " + ar);
            boolean b = arrayList.stream().anyMatch(ar1 -> {
                System.out.println("ar1 => " + ar1);
                switch (ar1) {
                    case "E":
                        System.out.println("array => " + ar1);
                        return true;
                    default:
                        break;
                }
                return false;
            });
            System.out.println(b);
            return b;
        });

        System.out.println("================== ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("arr = " + arrayList.get(i));
            if ("c".equalsIgnoreCase(arrayList.get(i))) {
                System.out.println("brr => " + arrayList.get(i));
                return;
            }
        }
    }

    @Test
    public void test11() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");

        int size = 3;
        int toIndex = size;
        for (int i = 0; i < arrayList.size(); i += size) {
            if (i + size > arrayList.size()) {
                toIndex = arrayList.size() - i;
            }
            List<String> pieceList = arrayList.subList(i, i + toIndex);
            System.out.println(pieceList);
        }
        arrayList.clear();
        System.out.println(arrayList);
    }

    @Test
    public void test12() {
        List<String> list = null;
        list.stream().forEach(item -> {
            System.out.println(item);
        });
    }

    @Test
    public void test13() {
        BigDecimal a = new BigDecimal("1.1");
        double exp = Math.exp(a.doubleValue());
        System.out.println(exp);
        BigDecimal b = new BigDecimal(String.valueOf(exp));
        System.out.println(b);
    }

    @Test
    public void test14() {
        List<Date> list = Arrays.asList(null, new Date());
        System.out.println(list.stream().filter(date -> date != null).map(date -> new SimpleDateFormat("yyyy-MM-dd").format(date)).collect(Collectors.joining(",")));
    }

    @Test
    public void test15() {
        BigDecimal a = new BigDecimal("0");
        BigDecimal b = new BigDecimal("1");
        for (int i = 0; i < 2; i++) {
            a = a.add(b);
        }

        System.out.println(a);
    }

    @Test
    public void test16() {
        Long a = 100L;
        Long b = 100L;

        System.out.println(a == b);
    }

    @Test
    public void test17() {
        List<BigDecimal> list = new ArrayList<>();
        boolean flag = list.stream().allMatch(a -> {
            return a.compareTo(BigDecimal.ZERO) > 0;
        });
        if (flag) {
            BigDecimal bigDecimal = list.stream().min(BigDecimal::compareTo).get();
            System.out.println(bigDecimal);
        }
        System.out.println(flag);
    }

    @Test
    public void test18() {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.stream().collect(Collectors.toMap(Integer::valueOf, Integer::valueOf)));
    }

    @Test
    public void test19() {
        System.out.println(new Date());
        System.out.println(ZoneId.systemDefault());
        System.out.println(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    /**
     * 4x^4 + 3x^3 - 8 = 0
     */
    @Test
    public void test20() {
//        StringBuffer formula = new StringBuffer("100 / Math.pow(x + 1, y)");
//        for (int i = 0; i < new BigDecimal("0.1562").intValue() + 1; i++) {
//            formula.append(String.format(" + z / Math.pow(x + 1, y - %d)", i));
//        }
//
//        System.out.println(formula.toString());
//        Expression expression = AviatorEvaluator.compile(formula.toString(), true);
//        Map<String, Object> paramsMap = new HashMap<String, Object>(){
//            {
//                put("y", new BigDecimal("0.1562"));
//                put("z", new BigDecimal("4.29"));
//            }
//        };

        double yieldToMaturityFloorThreshold = 0;
        double yieldToMaturityCeilThreshold = 1;
        double yieldToMaturity = 0;

        for (int i = 0; i < 50; i++) {
            String formula = "104.29/Math.pow(1+x, 1.6639) + 4.29/Math.pow(1+x, 0.6639)";
            yieldToMaturity = (yieldToMaturityFloorThreshold + yieldToMaturityCeilThreshold) / 2;
            Map<String, Object> paramsMap = new HashMap<String, Object>();
            paramsMap.put("x", new BigDecimal(String.valueOf(yieldToMaturity)));

            if (new BigDecimal(AviatorEvaluator.compile(formula, true).execute(paramsMap).toString()).compareTo(new BigDecimal("104.7457")) > 0) {
                yieldToMaturityFloorThreshold = yieldToMaturity;
            } else {
                yieldToMaturityCeilThreshold = yieldToMaturity;
            }
        }
        System.out.println(new BigDecimal(String.valueOf(yieldToMaturity)));
    }

    @Test
    public void test21() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + listNew);
    }

    @Test
    public void test22() {
        BigDecimal amount = new BigDecimal("123000000");
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(amount.toString());
        } else if (amount.divide(new BigDecimal("100000000")).compareTo(BigDecimal.ZERO) > 0) {
            System.out.println(String.format("%s亿", amount.divide(new BigDecimal("100000000"))));
        } else if (amount.divide(new BigDecimal("10000")).compareTo(BigDecimal.ZERO) > 0) {
            System.out.println(String.format("%f万", amount.divide(new BigDecimal("10000"))));
        }
    }

    @Test
    public void test23() {
        for (int i = 0; i < 5; i++) {
            Arrays.asList(1, 2, null, 4, null).stream().forEach(number -> {
                Optional.ofNullable(number).orElseThrow(() -> {
                    System.out.println(number);
                    return new NullPointerException();
                });
            });
            System.out.println(i);
        }
    }

    @Test
    public void test24() {
        List<BigDecimal> list = Arrays.asList(new BigDecimal("1"), new BigDecimal("2"), null);
        list.stream().sorted().forEach(a -> {
            System.out.println(a);
        });
    }

    @Test
    public void test25() {
        System.out.println(Long.parseLong(null));
    }

    @Test
    public void test26() {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

    @Test
    public void test27() {
        List<Integer> list = null;
        Optional.ofNullable(list).orElseGet(ArrayList::new).forEach(a -> {
            System.out.println(a);
        });
    }

    @Test
    public void test28() {
        Integer limit = 0;
        Integer offsize = 10000;
        limit = offsize;
        offsize += offsize;
        System.out.println(limit);
        System.out.println(offsize);
    }

    @Test
    public void test29() {
        List<String> list = new ArrayList<>();
        System.out.println(list.stream().collect(Collectors.toMap(Function.identity(), Function.identity())));
    }

    @Test
    public void test30() {
        System.out.println("/usr/哈123哈.111.postman_collection.json".matches(".+.postman_collection.json$"));
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Collections.singletonList(1));
        map.put(2, null);
        System.out.println(map.get(null));
    }

    @Test
    public void test31() {
        List<String> list = new ArrayList<>();
        System.out.println(list.get(0));
    }
}
package com.deepexi.ai.mes.test1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class Test2 {
    @Test
    public void fun1(){
        String a="[{\n" +
                "        \"filename\": \"D:\\\\experiment\\\\DriverStatus\\\\test2\\\\c0\\\\img_100026.jpg\",\n" +
                "        \"labels\": [\n" +
                "            \"c0\"\n" +
                "        ],\n" +
                "        \"possibility\": 0.4781594276,\n" +
                "        \"pred\": [\n" +
                "            \"c0\"\n" +
                "        ],\n" +
                "        \"results\": [\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c0\"\n" +
                "                ],\n" +
                "                0.4781594276\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c1\"\n" +
                "                ],\n" +
                "                0.0042373827\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c2\"\n" +
                "                ],\n" +
                "                0.0005494396\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c3\"\n" +
                "                ],\n" +
                "                0.163466379\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c4\"\n" +
                "                ],\n" +
                "                0.1045693234\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c5\"\n" +
                "                ],\n" +
                "                0.0005271414\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c6\"\n" +
                "                ],\n" +
                "                0.001264343\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c7\"\n" +
                "                ],\n" +
                "                0.0008313274\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c8\"\n" +
                "                ],\n" +
                "                0.0233317465\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c9\"\n" +
                "                ],\n" +
                "                0.2230635136\n" +
                "            ]\n" +
                "        ],\n" +
                "        \"true_or_false\": 1\n" +
                "    }]";
        JSONArray jsonObject = JSON.parseArray(a);
        JSONObject jsonObject1 = jsonObject.getJSONObject(0);
        //jsonObject1.getJSONArray("labels").
    }
}

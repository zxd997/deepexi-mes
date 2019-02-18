package com.deepexi.ai.mes;

import com.deepexi.ai.mes.dao.ITestResultDao;
import com.deepexi.ai.mes.model.TestResult;
import com.deepexi.ai.mes.service.ITestResultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MesApplicationTests {
    @Autowired
    ITestResultDao testResultDao;
    @Test
    public void contextLoads() throws IOException {
        //testResultUtil.uploadTestResult();
        long count = testResultDao.count();
        System.out.println(count);
    }
    @Test
    public void contextLoad1() throws IOException {
        List<TestResult> weightId = testResultDao.findByWeightIdAndPossibilityBetween(0.5, 1, "weightId");
        System.out.println(weightId.size());
    }
    @Autowired
    ITestResultService testResultService;
    @Test
    public void fun3(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://192.168.3.124:8050/model-001.h5", String.class);
        testResultService.saveMockAndMetaResultList(result);
    }
    @Test
    public void fun21(){
        String ab="[\n" +
                "    {\n" +
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
                "    },\n" +
                "    {\n" +
                "        \"filename\": \"D:\\\\experiment\\\\DriverStatus\\\\test2\\\\c0\\\\img_101159.jpg\",\n" +
                "        \"labels\": [\n" +
                "            \"c0\"\n" +
                "        ],\n" +
                "        \"possibility\": 0.5665228963,\n" +
                "        \"pred\": [\n" +
                "            \"c3\"\n" +
                "        ],\n" +
                "        \"results\": [\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c0\"\n" +
                "                ],\n" +
                "                0.2153311372\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c1\"\n" +
                "                ],\n" +
                "                0.0070874812\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c2\"\n" +
                "                ],\n" +
                "                0.0027137797\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c3\"\n" +
                "                ],\n" +
                "                0.5665228963\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c4\"\n" +
                "                ],\n" +
                "                0.026780678\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c5\"\n" +
                "                ],\n" +
                "                0.0037820742\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c6\"\n" +
                "                ],\n" +
                "                0.0066683544\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c7\"\n" +
                "                ],\n" +
                "                0.0015261263\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c8\"\n" +
                "                ],\n" +
                "                0.0223377477\n" +
                "            ],\n" +
                "            [\n" +
                "                [\n" +
                "                    \"c9\"\n" +
                "                ],\n" +
                "                0.1472498178\n" +
                "            ]\n" +
                "        ],\n" +
                "        \"true_or_false\": 0\n" +
                "    }\n" +
                "]";
        testResultService.saveMockAndMetaResultList(ab);
    }
}
